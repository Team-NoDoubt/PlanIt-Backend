package com.nodoubt.planitbackend.domain.changeMaster.presentation

import com.nodoubt.planitbackend.domain.changeMaster.api.ChangeTimetablePort
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.ChangeTimetableRequest
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.ReinforcementClassList
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.ReplacementClassList
import com.nodoubt.planitbackend.domain.changeMaster.presentation.dto.request.WebChangeMasterRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/timetable")
class ChangeMasterWebAdapter(
    private val changeTimetablePort: ChangeTimetablePort
) {

    @PostMapping
    fun changeTimetable(@RequestBody @Valid request: WebChangeMasterRequest) {
        changeTimetablePort.execute(
            ChangeTimetableRequest(
                reason = request.reason,
                reinforcementList = request.reinforcementList.map {
                    ReinforcementClassList(
                        reinforcementClassId = it.reinforcementClassId,
                        reinforcementPlan = it.reinforcementPlan,
                        reinforcementTeacherId = it.reinforcementTeacherId
                    )
                },
                replacementList = request.replacementList.map {
                    ReplacementClassList(
                        requestTimetableId = it.requestTimetableId,
                        changeTimetableId = it.changeTimetableId,
                        replacementTeacherId = it.replacementTeacherId
                    )
                }
            )
        )
    }
}