package com.nodoubt.planitbackend.domain.changeMaster.api.dto.response

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import java.time.LocalDate

class QueryRequestedTimetableListResponse(
    val requestedTimetableList: List<RequestedTimetableList>
)

data class RequestedTimetableList(
    val status: Status,
    val date: LocalDate
)