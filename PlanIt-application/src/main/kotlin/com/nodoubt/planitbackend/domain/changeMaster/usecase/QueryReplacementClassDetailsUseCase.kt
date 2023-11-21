package com.nodoubt.planitbackend.domain.changeMaster.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.changeMaster.api.QueryReplacementClassDetailsPort
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryReplacementClassDetailsResponse
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryReplacementClassDetailsResponse.TimetableInfo
import com.nodoubt.planitbackend.domain.changeMaster.exception.ReplacementClassNotFoundException
import com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi.QueryReplacementClassPort

@UseCase
open class QueryReplacementClassDetailsUseCase(
    private val queryReplacementClassPort: QueryReplacementClassPort,
) : QueryReplacementClassDetailsPort {

    override fun execute(replacementClassId: Long): QueryReplacementClassDetailsResponse {
        val vo = queryReplacementClassPort.queryReplacementClassDetailsById(replacementClassId)
            ?: throw ReplacementClassNotFoundException

        return QueryReplacementClassDetailsResponse(
            reason = vo.reason,
            TimetableInfo(
                date = vo.requestTimetableDate,
                weekOfDate = vo.requestTimetableWeekOfDate,
                period = vo.requestTimetablePeriod,
                grade = vo.requestTimetableGrade,
                classNum = vo.requestTimetableClassNum,
                subject = vo.requestTimetableSubject,
            ),
            TimetableInfo(
                date = vo.changeTimetableDate,
                weekOfDate = vo.changeTimetableWeekOfDate,
                period = vo.changeTimetablePeriod,
                grade = vo.changeTimetableGrade,
                classNum = vo.changeTimetableClassNum,
                subject = vo.changeTimetableSubject,
            ),
        )
    }
}