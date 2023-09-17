package com.nodoubt.planitbackend.domain.reinforcementClass.domain

import com.nodoubt.planitbackend.annotation.Aggregate

@Aggregate
class ReinforcementClass (

    val id: Long = 0,

    val changeMasterId: Long,

    val status: Status,

    val reinforcementPlan: String,

    val reasonRejected: String,

    val dateTimetableId: Long,

    val teacherId: Long
)