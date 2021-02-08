package com.dailyreport.dailywriter.application.lib.helper

import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class ViewHelper {
    fun formatDateSimply(localDateTime: LocalDateTime): String {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
    }
}