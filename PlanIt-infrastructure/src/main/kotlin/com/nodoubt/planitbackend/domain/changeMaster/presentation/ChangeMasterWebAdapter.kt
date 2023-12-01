package com.nodoubt.planitbackend.domain.changeMaster.presentation

import com.nodoubt.planitbackend.domain.changeMaster.api.*
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryReplacementClassDetailsResponse
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryReplacementClassListResponse
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryRequestedTimetableDetailsResponse
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryRequestedTimetableListResponse
import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.changeMaster.presentation.dto.request.WebChangeTimetableRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/change-master")
class ChangeMasterWebAdapter(
    private val changeTimetablePort: ChangeTimetablePort,
    private val queryRequestedTimetableListPort: QueryRequestedTimetableListPort,
    private val queryReplacementClassListPort: QueryReplacementClassListPort,
    private val queryReplacementClassDetailsPort: QueryReplacementClassDetailsPort,
    private val queryRequestedTimetableDetailsPort: QueryRequestedTimetableDetailsPort
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun changeTimetable(@RequestBody @Valid request: WebChangeTimetableRequest) {
        changeTimetablePort.execute(request.toDomainRequest(request))
    }

    @GetMapping("/requested")
    fun queryRequestedTimetableList(): QueryRequestedTimetableListResponse =
        queryRequestedTimetableListPort.execute()

    @GetMapping("/replacement-class")
    fun queryReplacementClassList(
        @RequestParam("status", required = false) status: Status?
    ): QueryReplacementClassListResponse {
        return queryReplacementClassListPort.execute(status)
    }

    @GetMapping("/replacement-class/{replacement-class-id}")
    fun queryReplacementClassDetails(
        @PathVariable("replacement-class-id") replacementClassId: Long
    ): QueryReplacementClassDetailsResponse {
        return queryReplacementClassDetailsPort.execute(replacementClassId)
    }

    @GetMapping("/requested/{change-master-id}")
    fun queryRequestedTimetableDetails(@PathVariable("change-master-id") changeMasterId: Long): QueryRequestedTimetableDetailsResponse =
        queryRequestedTimetableDetailsPort.execute(changeMasterId)

}