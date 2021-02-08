package com.dailyreport.dailywriter.application.infrastructure.table

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.date
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDate
import java.time.LocalDateTime

object DailyReportTable: LongIdTable("daily_reports") {
    val date: Column<LocalDate> = date("date")
    val doneContent: Column<String> = text("done_content")
    val memo: Column<String?> = text("memo").nullable()
    val createdAt: Column<LocalDateTime> = datetime("created_at").default(LocalDateTime.now())
    val updatedAt: Column<LocalDateTime> = datetime("updated_at").default(LocalDateTime.now())
}


