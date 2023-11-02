package com.nodoubt.planitbackend.domain.semesterTimetable.presentation

import com.nodoubt.planitbackend.domain.semesterTimetable.api.QuerySemesterTimetableIdPort
import com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.response.QuerySemesterTimetableIdResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/timetables/semester")
@RestController
class SemesterTimetableWebAdapter(
    private val querySemesterTimetableIdPort: QuerySemesterTimetableIdPort
) {

    @GetMapping
    fun querySemesterTimetableId(
        @RequestParam("week-of-date") weekOfDate: Int,
        @RequestParam("period") period: Int,
        @RequestParam("grade") grade: Int,
        @RequestParam("class") classNum: Int
    ): QuerySemesterTimetableIdResponse =
        querySemesterTimetableIdPort.execute(weekOfDate, grade, classNum, period)
}