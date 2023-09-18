package com.nodoubt.planitbackend.domain.replacementClass.domain

import com.nodoubt.planitbackend.annotation.Aggregate
import com.nodoubt.planitbackend.domain.changeMaster.domain.Status

@Aggregate
class ReplacementClass (
    val id: Long = 0,

    val changeMasterId: Long,

    val status: Status,

    val reasonRejected: String,

    val requestTimetableId: Long,

    val changeTimetableId: Long,

    val teacherId: Long
)