package com.nodoubt.planitbackend.domain.semesterTimetable.presentation

import com.nodoubt.planitbackend.domain.semesterTimetable.api.QuerySemesterTimetableIdPort
import com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.request.DomainQuerySemesterTimetableIdRequest
import com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.response.QuerySemesterTimetableIdResponse
import com.nodoubt.planitbackend.domain.semesterTimetable.presentation.dto.request.WebQuerySemesterTimetableIdRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/semester-timetable")
@RestController
class SemesterTimetableWebAdapter(
    private val querySemesterTimetableIdPort: QuerySemesterTimetableIdPort
) {

    @GetMapping
    fun querySemesterTimetableId(@RequestBody @Valid request: WebQuerySemesterTimetableIdRequest): QuerySemesterTimetableIdResponse =
        querySemesterTimetableIdPort.execute(
            DomainQuerySemesterTimetableIdRequest(
                weekOfDate = request.weekOfDate,
                period = request.period,
                grade = request.grade,
                classNum = request.classNum
            )
        )
}