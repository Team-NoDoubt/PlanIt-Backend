package com.nodoubt.planitbackend.domain.dateTimetable.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.dateTimetable.api.QueryChangedTimetablePort
import com.nodoubt.planitbackend.domain.dateTimetable.api.dto.response.ChangedTimetableResponse
import com.nodoubt.planitbackend.domain.dateTimetable.api.dto.response.QueryChangedTimetableResponse
import com.nodoubt.planitbackend.domain.dateTimetable.spi.QueryDateTimetablePort
import java.time.LocalDate

@UseCase
open class QueryChangedTimetableUseCase(
    private val queryDateTimetablePort: QueryDateTimetablePort
) : QueryChangedTimetablePort {

    override fun execute(grade: Int, classNum: Int): QueryChangedTimetableResponse {

        val monday = LocalDate.now().with(java.time.DayOfWeek.MONDAY)
        val friday = monday.plusDays(4)

        val changedTimetableList = queryDateTimetablePort.queryChangedTimetableList(grade, classNum, monday, friday)

        return QueryChangedTimetableResponse(
            changedTimetableList = changedTimetableList
                .map {
                    ChangedTimetableResponse(
                        requestDate = it.requestDate,
                        requestPeriod = it.requestPeriod,
                        requestSubject = it.requestSubject,
                        requestTeacher = it.requestTeacher,
                        changedDate = it.changedDate,
                        changedPeriod = it.changedPeriod,
                        changedSubject = it.changedSubject,
                        changedTeacher = it.changedTeacher
                    )
                }
        )
    }
}