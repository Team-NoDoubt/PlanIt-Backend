package com.nodoubt.planitbackend.domain.user.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.user.api.SignInPort
import com.nodoubt.planitbackend.domain.user.api.dto.request.DomainSignInRequest
import com.nodoubt.planitbackend.domain.user.api.dto.response.SignInResponse
import com.nodoubt.planitbackend.domain.user.domain.RefreshToken
import com.nodoubt.planitbackend.domain.user.exception.PasswordMisMatchException
import com.nodoubt.planitbackend.domain.user.spi.CommandRefreshPort
import com.nodoubt.planitbackend.domain.user.spi.QueryUserPort
import com.nodoubt.planitbackend.domain.user.spi.UserJwtPort
import com.nodoubt.planitbackend.domain.user.spi.UserSecurityPort
import java.time.ZoneOffset

@UseCase
open class SignInUseCase(
    private val queryUserPort: QueryUserPort,
    private val userJwtPort: UserJwtPort,
    private val commandRefreshPort: CommandRefreshPort,
    private val userSecurityPort: UserSecurityPort
) : SignInPort {

    override fun signIn(request: DomainSignInRequest): SignInResponse {
        val user = queryUserPort.queryUserByAccountId(request.accountId)

        if (!userSecurityPort.matches(request.password, user.password)) {
            throw PasswordMisMatchException
        }

        val tokenResponse = userJwtPort.provideBothToken(user.accountId, user.role)

        commandRefreshPort.saveRefreshToken(
            RefreshToken(
                id = user.accountId,
                refreshToken = tokenResponse.refreshToken,
                ttl = tokenResponse.accessTokenExp.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli()
            )
        )

        return SignInResponse(
            name = user.name,
            accessToken = tokenResponse.accessToken,
            refreshToken = tokenResponse.refreshToken,
            accessTokenExp = tokenResponse.accessTokenExp
        )
    }
}