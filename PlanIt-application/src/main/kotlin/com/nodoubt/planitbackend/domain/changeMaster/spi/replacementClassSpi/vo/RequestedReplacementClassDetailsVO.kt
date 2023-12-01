package com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi.vo

import java.time.LocalDate

open class RequestedReplacementClassDetailsVO(
    val requestTimetableDate: LocalDate,
    val requestTimetableWeekOfDate: Int,
    val requestPeriod: Int,
    val requestGrade: Int,
    val requestClassNum: Int,
    val requestSubject: String,
    val changeTimetableDate: LocalDate,
    val changeTimetableWeekOfDate: Int,
    val changePeriod: Int,
    val changeGrade: Int,
    val changeClassNum: Int,
    val changeSubject: String,
    val changeTeacher: String,
    val reasonRejected: String?
)