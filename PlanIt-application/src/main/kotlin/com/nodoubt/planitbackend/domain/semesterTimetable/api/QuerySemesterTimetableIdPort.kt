package com.nodoubt.planitbackend.domain.semesterTimetable.api

import com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.response.QuerySemesterTimetableIdResponse

interface QuerySemesterTimetableIdPort {
    fun execute(weekOfDate: Int, grade: Int, classNum: Int, period: Int): QuerySemesterTimetableIdResponse
}