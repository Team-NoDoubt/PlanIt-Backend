package com.nodoubt.planitbackend.domain.changeMaster.domain

import com.nodoubt.planitbackend.annotation.Aggregate
import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import java.time.LocalDate

@Aggregate
class ReinforcementClass (

    val id: Long = 0,

    val changeMasterId: Long,

    val status: Status,

    val reinforcementPlan: String,

    val reasonRejected: String? = null,

    val semesterTimetableId: Long,

    val timetableDate: LocalDate,

    val teacherId: Long
)