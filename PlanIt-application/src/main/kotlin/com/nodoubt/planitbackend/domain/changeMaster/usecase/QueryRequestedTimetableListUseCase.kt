package com.nodoubt.planitbackend.domain.changeMaster.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.changeMaster.api.QueryRequestedTimetableListPort
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.QueryRequestedTimetableListResponse
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.response.RequestedTimetableList
import com.nodoubt.planitbackend.domain.changeMaster.spi.QueryChangedMasterPort
import com.nodoubt.planitbackend.domain.user.spi.UserSecurityPort

@UseCase
open class QueryRequestedTimetableListUseCase (
    private val userSecurityPort: UserSecurityPort,
    private val queryChangedMasterPort: QueryChangedMasterPort
) : QueryRequestedTimetableListPort {

    override fun execute(): QueryRequestedTimetableListResponse {
        val user = userSecurityPort.getCurrentUser()

        val requestedTimetable = queryChangedMasterPort.queryRequestedTimetableByUserId(user.id)

        return QueryRequestedTimetableListResponse(
            requestedTimetableList = requestedTimetable.map {
                RequestedTimetableList(
                    status = it.status,
                    date = it.date
                )
            }
        )
    }
}