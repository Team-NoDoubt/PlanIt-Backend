package com.nodoubt.planitbackend.domain.replacementClass.domain

import com.nodoubt.planitbackend.annotation.Aggregate
import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import java.time.LocalDate

@Aggregate
class ReplacementClass (
    val id: Long = 0,

    val changeMasterId: Long,

    val status: Status,

    val reasonRejected: String? = null,

    val requestTimetableId: Long,

    val requestTimetableDate: LocalDate,

    val changeTimetableId: Long,

    val changeTimetableDate: LocalDate,

    val teacherId: Long
)