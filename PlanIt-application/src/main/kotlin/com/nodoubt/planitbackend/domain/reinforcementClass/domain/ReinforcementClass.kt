package com.nodoubt.planitbackend.domain.reinforcementClass.domain

import com.nodoubt.planitbackend.annotation.Aggregate
import com.nodoubt.planitbackend.domain.changeMaster.domain.Status

@Aggregate
class ReinforcementClass (

    val id: Long = 0,

    val changeMasterId: Long,

    val status: Status,

    val reinforcementPlan: String,

    val reasonRejected: String? = null,

    val dateTimetableId: Long,

    val teacherId: Long
)