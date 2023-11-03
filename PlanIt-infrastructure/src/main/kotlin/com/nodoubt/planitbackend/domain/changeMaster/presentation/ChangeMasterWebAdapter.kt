package com.nodoubt.planitbackend.domain.changeMaster.presentation

import com.nodoubt.planitbackend.domain.changeMaster.api.ChangeTimetablePort
import com.nodoubt.planitbackend.domain.changeMaster.api.QueryRequestedTimetableListPort
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryRequestedTimetableListResponse
import com.nodoubt.planitbackend.domain.changeMaster.presentation.dto.request.WebChangeTimetableRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/timetables")
class ChangeMasterWebAdapter(
    private val changeTimetablePort: ChangeTimetablePort,
    private val queryRequestedTimetableListPort: QueryRequestedTimetableListPort
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun changeTimetable(@RequestBody @Valid request: WebChangeTimetableRequest) {
        changeTimetablePort.execute(request.toDomainRequest(request))
    }

    @GetMapping("/requested")
    fun queryRequestedTimetableList(): QueryRequestedTimetableListResponse =
        queryRequestedTimetableListPort.execute()
}