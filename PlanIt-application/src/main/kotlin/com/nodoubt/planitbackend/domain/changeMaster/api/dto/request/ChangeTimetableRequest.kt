package com.nodoubt.planitbackend.domain.changeMaster.api.dto.request

class ChangeTimetableRequest (
    val reason: String,
    val reinforcementList: List<ReinforcementClassList>,
    val replacementList: List<ReplacementClassList>
)

data class ReinforcementClassList(
    val reinforcementClassId: Long,
    val reinforcementPlan: String,
    val reinforcementTeacherId: Long
)

data class ReplacementClassList(
    val requestTimetableId: Long,
    val changeTimetableId: Long,
    val replacementTeacherId: Long
)