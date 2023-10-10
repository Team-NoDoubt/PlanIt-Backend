package com.nodoubt.planitbackend.domain.changeMaster.api

import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryRequestedTimetableListResponse

interface QueryRequestedTimetableListPort {
    fun execute(): QueryRequestedTimetableListResponse
}