package com.nodoubt.planitbackend.domain.semesterTimetable.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.semesterTimetable.api.QuerySemesterTimetableIdPort
import com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.response.QuerySemesterTimetableIdResponse
import com.nodoubt.planitbackend.domain.semesterTimetable.spi.QuerySemesterTimetablePort

@UseCase
open class QuerySemesterTimetableIdUseCase(
    private val querySemesterTimetablePort: QuerySemesterTimetablePort
) : QuerySemesterTimetableIdPort {

    override fun execute(weekOfDate: Int, grade: Int, classNum: Int, period: Int): QuerySemesterTimetableIdResponse {

        val semesterEntity = querySemesterTimetablePort.querySemesterTimetableIdByWeekOfDateAndPeriodAndGradeAndClassNum(weekOfDate, grade, classNum, period)

        return QuerySemesterTimetableIdResponse(
            timetableId = semesterEntity.id,
            subject = semesterEntity.subject
        )
    }
}