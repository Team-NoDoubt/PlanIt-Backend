package com.nodoubt.planitbackend.domain.replacementClass.api

import com.nodoubt.planitbackend.domain.replacementClass.api.dto.response.QueryReplacementClassDetailsResponse

interface QueryReplacementClassDetailsPort {
    fun execute(replacementClassId: Long): QueryReplacementClassDetailsResponse
}
