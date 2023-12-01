package com.nodoubt.planitbackend.domain.replacementClass.persistence.vo

import com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi.vo.RequestedReplacementClassDetailsVO
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDate

class QueryRequestedReplacementClassDetailsVO @QueryProjection constructor(
    requestTimetableDate: LocalDate,
    requestTimetableWeekOfDate: Int,
    requestPeriod: Int,
    requestGrade: Int,
    requestClassNum: Int,
    requestSubject: String,
    changeTimetableDate: LocalDate,
    changeTimetableWeekOfDate: Int,
    changePeriod: Int,
    changeGrade: Int,
    changeClassNum: Int,
    changeSubject: String,
    changeTeacher: String,
    reasonRejected: String?
) : RequestedReplacementClassDetailsVO(
    requestTimetableDate = requestTimetableDate,
    requestTimetableWeekOfDate = requestTimetableWeekOfDate,
    requestPeriod = requestPeriod,
    requestGrade = requestGrade,
    requestClassNum = requestClassNum,
    requestSubject = requestSubject,
    changeTimetableDate = changeTimetableDate,
    changeTimetableWeekOfDate = changeTimetableWeekOfDate,
    changePeriod = changePeriod,
    changeGrade = changeGrade,
    changeClassNum = changeClassNum,
    changeSubject = changeSubject,
    changeTeacher = changeTeacher,
    reasonRejected = reasonRejected
)