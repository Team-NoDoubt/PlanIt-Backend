package com.nodoubt.planitbackend.domain.changeMaster.api

import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryReplacementClassDetailsResponse

interface QueryReplacementClassDetailsPort {
    fun execute(replacementClassId: Long): QueryReplacementClassDetailsResponse
}
