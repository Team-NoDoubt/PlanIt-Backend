package com.nodoubt.planitbackend.domain.dateTimetable.spi.vo

import java.time.LocalDate

open class ChangedTimetableVO (
    val requestDate: LocalDate,
    val requestPeriod: Int,
    val requestSubject: String,
    val requestTeacher: String,
    val changedDate: LocalDate,
    val changedPeriod: Int,
    val changedSubject: String,
    val changedTeacher: String
)