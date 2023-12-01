package com.nodoubt.planitbackend.domain.changeMaster.api

import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryRequestedTimetableDetailsResponse

interface QueryRequestedTimetableDetailsPort {
    fun execute(changeMasterId: Long): QueryRequestedTimetableDetailsResponse
}