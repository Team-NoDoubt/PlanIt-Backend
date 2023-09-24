package com.nodoubt.planitbackend.domain.replacementClass.presentation

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.replacementClass.api.QueryReplacementClassListPort
import com.nodoubt.planitbackend.domain.replacementClass.api.dto.response.QueryReplacementClassListResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/replacement-class")
@RestController
class ReplacementClassWebAdapter(
    private val queryReplacementClassListPort: QueryReplacementClassListPort,
) {

    @GetMapping
    fun queryReplacementClassList(
        @RequestParam("status", required = false) status: Status?
    ): QueryReplacementClassListResponse {
        return queryReplacementClassListPort.execute(status)
    }
}