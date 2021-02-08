package com.dailyreport.dailywriter.application.form

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

class DailyReportRegisterForm {
    @DateTimeFormat(pattern="yyyy-MM-dd")
    var date: LocalDate? = null
    var doneContent: String? = null
    var memo: String? = null
}
