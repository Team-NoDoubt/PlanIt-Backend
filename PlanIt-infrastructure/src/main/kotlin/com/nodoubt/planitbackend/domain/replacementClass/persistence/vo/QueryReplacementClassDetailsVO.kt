package com.nodoubt.planitbackend.domain.replacementClass.persistence.vo

import com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi.vo.ReplacementClassDetailsVO
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDate

class QueryReplacementClassDetailsVO @QueryProjection constructor(
    reason: String,
    requestTimetableDate: LocalDate,
    requestTimetableWeekOfDate: Int,
    requestTimetablePeriod: Int,
    requestTimetableGrade: Int,
    requestTimetableClassNum: Int,
    requestTimetableSubject: String,
    changeTimetableDate: LocalDate,
    changeTimetableWeekOfDate: Int,
    changeTimetablePeriod: Int,
    changeTimetableGrade: Int,
    changeTimetableClassNum: Int,
    changeTimetableSubject: String,
) : ReplacementClassDetailsVO(
    reason = reason,
    requestTimetableDate = requestTimetableDate,
    requestTimetableWeekOfDate = requestTimetableWeekOfDate,
    requestTimetablePeriod = requestTimetablePeriod,
    requestTimetableGrade = requestTimetableGrade,
    requestTimetableClassNum = requestTimetableClassNum,
    requestTimetableSubject = requestTimetableSubject,
    changeTimetableDate = changeTimetableDate,
    changeTimetableWeekOfDate = changeTimetableWeekOfDate,
    changeTimetablePeriod = changeTimetablePeriod,
    changeTimetableGrade = changeTimetableGrade,
    changeTimetableClassNum = changeTimetableClassNum,
    changeTimetableSubject = changeTimetableSubject,
)