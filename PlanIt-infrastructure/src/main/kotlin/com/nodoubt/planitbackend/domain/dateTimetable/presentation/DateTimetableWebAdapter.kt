package com.nodoubt.planitbackend.domain.dateTimetable.presentation

import com.nodoubt.planitbackend.domain.dateTimetable.api.QueryDateTimetableListPort
import com.nodoubt.planitbackend.domain.dateTimetable.api.dto.response.QueryDateTimetableListResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/timetable")
@RestController
class DateTimetableWebAdapter (
    private val queryDateTimetableListPort: QueryDateTimetableListPort
) {

    @GetMapping
    fun getTimetableList(@RequestParam("grade") grade: Int, @RequestParam("class") classNum: Int): QueryDateTimetableListResponse {
        return queryDateTimetableListPort.execute(grade, classNum)
    }
}