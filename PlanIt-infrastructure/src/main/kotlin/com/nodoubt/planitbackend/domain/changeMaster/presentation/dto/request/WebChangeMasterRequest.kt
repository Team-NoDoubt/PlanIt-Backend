package com.nodoubt.planitbackend.domain.changeMaster.presentation.dto.request

import com.nodoubt.planitbackend.global.exception.UnprocessableEntityException
import javax.validation.constraints.NotBlank

class WebChangeMasterRequest(

    @NotBlank
    val reason: String,

    val reinforcementList: List<ReinforcementClassList>,
    val replacementList: List<ReplacementClassList>
) {
    init {
        if (reinforcementList.isEmpty() && replacementList.isEmpty()) {
            throw UnprocessableEntityException
        }
    }
}

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
