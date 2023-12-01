package com.nodoubt.planitbackend.domain.changeMaster.spi.reinforcementClassSpi.vo

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import java.time.LocalDate

open class RequestedReinforcementClassDetailsVO (
    val timetableDate: LocalDate,
    val period: Int,
    val grade: Int,
    val classNum: Int,
    val subject: String,
    val reinforcementPlan: String,
    val reinforcementTeacher: String,
    val status: Status,
    val reasonRejected: String?
)