package com.nodoubt.planitbackend.domain.dateTimetable.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.dateTimetable.api.QueryDateTimetableListPort
import com.nodoubt.planitbackend.domain.dateTimetable.api.dto.response.QueryDateTimetableListResponse
import com.nodoubt.planitbackend.domain.dateTimetable.api.dto.response.TimetableResponse
import com.nodoubt.planitbackend.domain.dateTimetable.spi.QueryDateTimetablePort
import java.time.LocalDate

@UseCase
open class QueryDateTimetableUseCase (
    private val queryDateTimetablePort: QueryDateTimetablePort
) : QueryDateTimetableListPort {

    override fun execute(grade: Int, classNum: Int): QueryDateTimetableListResponse {
        val monday = LocalDate.now().with(java.time.DayOfWeek.MONDAY)
        val friday = monday.plusDays(4)

        val timetableList = queryDateTimetablePort.queryDateTimetableList(grade, classNum, monday, friday)

        return QueryDateTimetableListResponse(
            timetableList = timetableList
                .map {
                    TimetableResponse(
                        grade = it.grade,
                        classNum = it.classNum,
                        period = it.period,
                        weekOfDate = it.weekOfDate,
                        subject = it.subject
                    )
                }
        )
    }
}
