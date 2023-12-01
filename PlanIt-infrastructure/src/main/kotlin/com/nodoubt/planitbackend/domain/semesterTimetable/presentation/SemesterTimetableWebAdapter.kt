package com.nodoubt.planitbackend.domain.semesterTimetable.presentation

import com.nodoubt.planitbackend.domain.semesterTimetable.api.QuerySemesterTimetableIdPort
import com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.response.QuerySemesterTimetableIdResponse
import com.nodoubt.planitbackend.domain.semesterTimetable.presentation.dto.request.GetSemesterTimetableIdRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/timetables/semester")
@RestController
class SemesterTimetableWebAdapter(
    private val querySemesterTimetableIdPort: QuerySemesterTimetableIdPort
) {

    @GetMapping
    fun querySemesterTimetableId(@ModelAttribute @Valid request: GetSemesterTimetableIdRequest): QuerySemesterTimetableIdResponse =
        querySemesterTimetableIdPort.execute(request.weekOfDate, request.grade, request.classNum, request.period)
}