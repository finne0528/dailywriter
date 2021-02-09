package com.dailyreport.dailywriter.application.controller

import com.dailyreport.dailywriter.application.constant.TemplateMapping
import com.dailyreport.dailywriter.application.form.DailyReportRegisterForm
import com.dailyreport.dailywriter.application.repository.DailyReportRepository
import com.dailyreport.dailywriter.application.service.SlackNotificationService
import com.dailyreport.dailywriter.config.DatabaseConfig
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.time.LocalDateTime
import java.time.LocalDate


@Controller
@RequestMapping("/dailyreport")
class DailyReportController(
    databaseConfig: DatabaseConfig,
    private val dailyReportRepository: DailyReportRepository,
    private val slackNotificationService: SlackNotificationService
) {
    init {
        databaseConfig.getConnection()
    }

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("reports", dailyReportRepository.getAll())

        return TemplateMapping.DAILY_REPORT_INDEX.value
    }

    @GetMapping("/register/")
    fun getRegister(model: Model): String {
        model.addAttribute("now", LocalDateTime.now())

        return TemplateMapping.DAILY_REPORT_REGISTER.value
    }

    @PostMapping("/register/")
    fun postRegister(
        redirectAttributes: RedirectAttributes,
        @Validated @ModelAttribute registerForm: DailyReportRegisterForm,
        bindingResult: BindingResult
    ): String {
        val date: LocalDate = registerForm.date ?: return "redirect:/dailyreport/register/".also { redirectAttributes.addFlashAttribute("error","日時が指定されていません") }
        val doneContent: String = registerForm.doneContent ?: return "redirect:/dailyreport/register/".also { redirectAttributes.addFlashAttribute("error","本日行ったことが入力されていません") }
        val memo: String? = registerForm.memo

        this.dailyReportRepository.insert(
            date,
            doneContent,
            memo
        )

        this.slackNotificationService.sendDailyreportRegisterNotification(date, doneContent, memo)

        return "redirect:/dailyreport/".also { redirectAttributes.addFlashAttribute("registered", true) }
    }
}
