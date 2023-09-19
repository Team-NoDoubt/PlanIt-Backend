package com.nodoubt.planitbackend.domain.changeMaster.presentation.dto.request

import com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.ChangeTimetableRequest
import com.nodoubt.planitbackend.global.exception.UnprocessableEntityException
import javax.validation.constraints.NotBlank

class WebChangeTimetableRequest(

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

    fun toDomainRequest(webChangeMasterRequest: WebChangeTimetableRequest): ChangeTimetableRequest =
        ChangeTimetableRequest(
            reason = webChangeMasterRequest.reason,
            reinforcementList = webChangeMasterRequest.reinforcementList.map {
                com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.ReinforcementClassList(
                    reinforcementClassId = it.reinforcementClassId,
                    reinforcementPlan = it.reinforcementPlan,
                    reinforcementTeacherId = it.reinforcementTeacherId
                )
            },
            replacementList = webChangeMasterRequest.replacementList.map {
                com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.ReplacementClassList(
                    requestTimetableId = it.requestTimetableId,
                    changeTimetableId = it.changeTimetableId,
                    replacementTeacherId = it.replacementTeacherId
                )
            }
        )
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
