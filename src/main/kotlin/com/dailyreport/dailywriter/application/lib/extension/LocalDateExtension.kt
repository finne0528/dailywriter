package com.dailyreport.dailywriter.application.lib.extension

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.formatDateSimply(): String {
    return this.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
}

fun LocalDate.formatDateSimply(): String {
    return this.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
}
