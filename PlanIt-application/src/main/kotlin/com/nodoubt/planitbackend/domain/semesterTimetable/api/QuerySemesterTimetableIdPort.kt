package com.nodoubt.planitbackend.domain.semesterTimetable.api

import com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.request.DomainQuerySemesterTimetableIdRequest
import com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.response.QuerySemesterTimetableIdResponse

interface QuerySemesterTimetableIdPort {
    fun execute(request: DomainQuerySemesterTimetableIdRequest): QuerySemesterTimetableIdResponse
}