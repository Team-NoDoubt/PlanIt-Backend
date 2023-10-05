package com.nodoubt.planitbackend.domain.replacementClass.api

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.replacementClass.api.dto.response.QueryReplacementClassListResponse

interface QueryReplacementClassListPort {
    fun execute(status: Status?): QueryReplacementClassListResponse
}