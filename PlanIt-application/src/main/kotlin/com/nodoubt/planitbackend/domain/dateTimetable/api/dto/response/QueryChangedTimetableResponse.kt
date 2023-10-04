package com.nodoubt.planitbackend.domain.dateTimetable.api.dto.response

import java.time.LocalDate

class QueryChangedTimetableResponse (
    val changedTimetableList: List<ChangedTimetableResponse>
)

data class ChangedTimetableResponse(
    val requestDate: LocalDate,
    val requestPeriod: Int,
    val requestSubject: String,
    val requestTeacher: String,
    val changedDate: LocalDate,
    val changedPeriod: Int,
    val changedSubject: String,
    val changedTeacher: String
)