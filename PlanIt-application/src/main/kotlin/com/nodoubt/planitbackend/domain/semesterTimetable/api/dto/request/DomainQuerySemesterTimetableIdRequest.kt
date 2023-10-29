package com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.request

class DomainQuerySemesterTimetableIdRequest (
    val weekOfDate: Int,
    val grade: Int,
    val classNum: Int,
    val period: Int
)