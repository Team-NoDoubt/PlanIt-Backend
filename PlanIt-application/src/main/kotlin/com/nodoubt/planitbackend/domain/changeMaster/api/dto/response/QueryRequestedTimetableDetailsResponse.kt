package com.nodoubt.planitbackend.domain.changeMaster.api.dto.response

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import java.time.LocalDate

class QueryRequestedTimetableDetailsResponse (
    val reason: String,
    val reinforcementClassList: List<ReinforcementClassDetail>,
    val replacementClassList: List<ReplacementClassDetail>
)

data class ReinforcementClassDetail(
    val timetableDate: LocalDate,
    val period: Int,
    val grade: Int,
    val classNum: Int,
    val subject: String,
    val reinforcementPlan: String,
    val reinforcementTeacher: String,
    val status: Status,
    val reasonRejected: String?
)

data class ReplacementClassDetail(
    val requestTimetableDate: LocalDate,
    val requestTimetableWeekOfDate: Int,
    val requestPeriod: Int,
    val requestGrade: Int,
    val requestClassNum: Int,
    val requestSubject: String,
    val changeTimetableDate: LocalDate,
    val changeTimetableWeekOfDate: Int,
    val changePeriod: Int,
    val changeGrade: Int,
    val changeClassNum: Int,
    val changeSubject: String,
    val changeTeacher: String,
    val reasonRejected: String?
)