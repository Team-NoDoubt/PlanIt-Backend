package com.nodoubt.planitbackend.domain.replacementClass.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.replacementClass.api.QueryReplacementClassListPort
import com.nodoubt.planitbackend.domain.replacementClass.api.dto.response.QueryReplacementClassListResponse
import com.nodoubt.planitbackend.domain.replacementClass.spi.QueryReplacementClassPort
import com.nodoubt.planitbackend.domain.user.spi.UserSecurityPort

@UseCase
open class QueryReplacementClassListUseCase(
    private val queryReplacementPort: QueryReplacementClassPort,
    private val securityPort: UserSecurityPort,
) : QueryReplacementClassListPort {

    override fun execute(status: Status?): QueryReplacementClassListResponse {
        val user = securityPort.getCurrentUser()
        return QueryReplacementClassListResponse(
            queryReplacementPort.queryReplacementClassListByUserId(user.id, status)
        )
    }
}