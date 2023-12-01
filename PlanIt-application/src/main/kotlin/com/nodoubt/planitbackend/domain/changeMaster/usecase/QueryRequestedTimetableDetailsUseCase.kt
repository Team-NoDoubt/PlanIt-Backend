package com.nodoubt.planitbackend.domain.changeMaster.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.changeMaster.api.QueryRequestedTimetableDetailsPort
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryRequestedTimetableDetailsResponse
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.ReinforcementClassDetail
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.ReplacementClassDetail
import com.nodoubt.planitbackend.domain.changeMaster.spi.changeMasterSpi.QueryChangedMasterPort
import com.nodoubt.planitbackend.domain.changeMaster.spi.reinforcementClassSpi.QueryReinforcementClassPort
import com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi.QueryReplacementClassPort

@UseCase
open class QueryRequestedTimetableDetailsUseCase(
    private val queryChangedMasterPort: QueryChangedMasterPort,
    private val queryReinforcementClassPort: QueryReinforcementClassPort,
    private val queryReplacementClassPort: QueryReplacementClassPort
) : QueryRequestedTimetableDetailsPort {

    override fun execute(changeMasterId: Long): QueryRequestedTimetableDetailsResponse {

        val changeMaster = queryChangedMasterPort.queryChangedMasterDetailsById(changeMasterId)

        val reinforcementClassDetailsList = queryReinforcementClassPort.queryReinforcementClassByChangeMasterId(changeMasterId)

        val replacementClassDetailsList = queryReplacementClassPort.queryReplacementClassDetailsByChangeMasterId(changeMasterId)

        return QueryRequestedTimetableDetailsResponse(
            reason = changeMaster.reason,
            reinforcementClassList = reinforcementClassDetailsList.map {
                ReinforcementClassDetail(
                    timetableDate = it.timetableDate,
                    period = it.period,
                    grade = it.grade,
                    classNum = it.classNum,
                    subject = it.subject,
                    reinforcementPlan = it.reinforcementPlan,
                    reinforcementTeacher = it.reinforcementTeacher,
                    status = it.status,
                    reasonRejected = it.reasonRejected
                )
            },
            replacementClassList = replacementClassDetailsList.map {
                ReplacementClassDetail(
                    requestTimetableDate = it.requestTimetableDate,
                    requestTimetableWeekOfDate = it.requestTimetableWeekOfDate,
                    requestPeriod = it.requestPeriod,
                    requestGrade = it.requestGrade,
                    requestClassNum = it.requestClassNum,
                    requestSubject = it.requestSubject,
                    changeTimetableDate = it.changeTimetableDate,
                    changeTimetableWeekOfDate = it.changeTimetableWeekOfDate,
                    changePeriod = it.changePeriod,
                    changeGrade = it.changeGrade,
                    changeClassNum = it.changeClassNum,
                    changeSubject = it.changeSubject,
                    changeTeacher = it.changeTeacher,
                    reasonRejected = it.reasonRejected
                )
            }
        )
    }
}