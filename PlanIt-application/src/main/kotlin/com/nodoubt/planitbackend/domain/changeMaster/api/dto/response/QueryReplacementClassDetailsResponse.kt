package com.nodoubt.planitbackend.domain.changeMaster.api.dto.response

import java.time.LocalDate

class QueryReplacementClassDetailsResponse(
    val reason: String,
    val requestTimetable: TimetableInfo,
    val changeTimetable: TimetableInfo,
) {
    class TimetableInfo(
        val date: LocalDate,
        val weekOfDate: Int,
        val period: Int,
        val grade: Int,
        val classNum: Int,
        val subject: String,
    )
}
