package com.nodoubt.planitbackend.domain.semesterTimetable.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.semesterTimetable.api.QuerySemesterTimetableIdPort
import com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.request.DomainQuerySemesterTimetableIdRequest
import com.nodoubt.planitbackend.domain.semesterTimetable.api.dto.response.QuerySemesterTimetableIdResponse
import com.nodoubt.planitbackend.domain.semesterTimetable.spi.QuerySemesterTimetablePort

@UseCase
open class QuerySemesterTimetableIdUseCase(
    private val querySemesterTimetablePort: QuerySemesterTimetablePort
) : QuerySemesterTimetableIdPort {

    override fun execute(request: DomainQuerySemesterTimetableIdRequest): QuerySemesterTimetableIdResponse {

        val semesterEntity = querySemesterTimetablePort.querySemesterTimetableIdByWeekOfDateAndPeriodAndGradeAndClassNum(request.weekOfDate, request.grade, request.classNum, request.period)

        return QuerySemesterTimetableIdResponse(
            timetableId = semesterEntity.id
        )
    }
}