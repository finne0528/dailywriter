package com.dailyreport.dailywriter.application.entity

import com.dailyreport.dailywriter.application.infrastructure.table.DailyReportTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDate
import java.time.LocalDateTime

class DailyReport(id: EntityID<Long>): LongEntity(id) {
    companion object: LongEntityClass<DailyReport>(DailyReportTable)
    var date: LocalDate by DailyReportTable.date
    var doneContent: String by DailyReportTable.doneContent
    var memo: String? by DailyReportTable.memo
    var createdAt: LocalDateTime by DailyReportTable.createdAt
    var updatedAt: LocalDateTime by DailyReportTable.updatedAt
}
