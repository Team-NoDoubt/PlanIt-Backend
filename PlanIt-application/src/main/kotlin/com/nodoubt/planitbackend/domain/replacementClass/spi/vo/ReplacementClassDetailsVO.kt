package com.nodoubt.planitbackend.domain.replacementClass.spi.vo

import java.time.LocalDate

open class ReplacementClassDetailsVO(
    val reason: String,
    val requestTimetableDate: LocalDate,
    val requestTimetableWeekOfDate: Int,
    val requestTimetablePeriod: Int,
    val requestTimetableGrade: Int,
    val requestTimetableClassNum: Int,
    val requestTimetableSubject: String,
    val changeTimetableDate: LocalDate,
    val changeTimetableWeekOfDate: Int,
    val changeTimetablePeriod: Int,
    val changeTimetableGrade: Int,
    val changeTimetableClassNum: Int,
    val changeTimetableSubject: String,
)