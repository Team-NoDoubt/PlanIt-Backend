package com.nodoubt.planitbackend.domain.dateTimetable.persistence.vo

import com.nodoubt.planitbackend.domain.dateTimetable.spi.vo.ChangedTimetableVO
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDate

class QueryChangedTimetableVO @QueryProjection constructor(
    requestDate: LocalDate,

    requestPeriod: Int,

    requestSubject: String,

    requestTeacher: String,

    changedDate: LocalDate,

    changedPeriod: Int,

    changedSubject: String,

    changedTeacher: String

) : ChangedTimetableVO(
    requestDate = requestDate,
    requestPeriod = requestPeriod,
    requestSubject = requestSubject,
    requestTeacher = requestTeacher,
    changedDate = changedDate,
    changedPeriod = changedPeriod,
    changedSubject = changedSubject,
    changedTeacher = changedTeacher
)