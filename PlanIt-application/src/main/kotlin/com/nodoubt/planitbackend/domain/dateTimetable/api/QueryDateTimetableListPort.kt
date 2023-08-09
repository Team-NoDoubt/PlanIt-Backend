package com.nodoubt.planitbackend.domain.dateTimetable.api

import com.nodoubt.planitbackend.domain.dateTimetable.api.dto.response.QueryDateTimetableListResponse

interface QueryDateTimetableListPort {

    fun execute(grade: Int, classNum: Int): QueryDateTimetableListResponse
}