package com.nodoubt.planitbackend.domain.changeMaster.api.dto.request

import java.time.LocalDate

class ChangeTimetableRequest (
    val reason: String,
    val reinforcementList: List<ReinforcementClassList>,
    val replacementList: List<ReplacementClassList>
)

data class ReinforcementClassList(
    val reinforcementClassId: Long,
    val reinforcementClassDate: LocalDate,
    val reinforcementPlan: String,
    val reinforcementTeacherId: Long
)

data class ReplacementClassList(
    val requestTimetableId: Long,
    val requestClassDate: LocalDate,
    val changeTimetableId: Long,
    val changeClassDate: LocalDate,
    val replacementTeacherId: Long
)