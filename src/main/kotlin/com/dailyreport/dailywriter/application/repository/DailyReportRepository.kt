package com.dailyreport.dailywriter.application.repository

import com.dailyreport.dailywriter.application.entity.DailyReport
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class DailyReportRepository {
    fun getAll(): List<DailyReport> = transaction {
        DailyReport.all().toList()
    }

    fun insert(date: LocalDate, doneContent: String, memo: String?) = transaction {
        DailyReport.new {
            this.date = date
            this.doneContent = doneContent
            this.memo = memo
        }
    }
}
