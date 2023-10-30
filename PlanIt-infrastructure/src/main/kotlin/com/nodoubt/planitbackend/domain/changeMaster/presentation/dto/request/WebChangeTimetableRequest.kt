package com.nodoubt.planitbackend.domain.changeMaster.presentation.dto.request

import com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.DomainChangeTimetableRequest
import com.nodoubt.planitbackend.global.exception.UnprocessableEntityException
import java.time.LocalDate
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

    fun toDomainRequest(webChangeMasterRequest: WebChangeTimetableRequest): DomainChangeTimetableRequest =
        DomainChangeTimetableRequest(
            reason = webChangeMasterRequest.reason,
            reinforcementList = webChangeMasterRequest.reinforcementList.map {
                com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.ReinforcementClassList(
                    reinforcementClassId = it.reinforcementClassId,
                    reinforcementClassDate = it.reinforcementClassDate,
                    reinforcementPlan = it.reinforcementPlan,
                    reinforcementTeacherId = it.reinforcementTeacherId
                )
            },
            replacementList = webChangeMasterRequest.replacementList.map {
                com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.ReplacementClassList(
                    requestTimetableId = it.requestTimetableId,
                    requestClassDate = it.requestClassDate,
                    changeTimetableId = it.changeTimetableId,
                    changeClassDate = it.changeClassDate,
                    replacementTeacherId = it.replacementTeacherId
                )
            }
        )
}

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
