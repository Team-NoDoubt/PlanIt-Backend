package com.nodoubt.planitbackend.domain.dateTimetable.api

import com.nodoubt.planitbackend.domain.dateTimetable.api.dto.response.QueryChangedTimetableResponse

interface QueryChangedTimetablePort {
    fun execute(grade: Int, classNum: Int): QueryChangedTimetableResponse
}