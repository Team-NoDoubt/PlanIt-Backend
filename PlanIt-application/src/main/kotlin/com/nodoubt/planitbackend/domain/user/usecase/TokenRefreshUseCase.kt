package com.nodoubt.planitbackend.domain.user.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.user.api.TokenRefreshPort
import com.nodoubt.planitbackend.domain.user.api.dto.response.TokenResponse
import com.nodoubt.planitbackend.domain.user.spi.CommandRefreshPort
import com.nodoubt.planitbackend.domain.user.spi.QueryRefreshTokenPort
import com.nodoubt.planitbackend.domain.user.spi.UserJwtPort
import com.nodoubt.planitbackend.domain.user.spi.UserSecurityPort
import java.time.ZoneOffset

@UseCase
open class TokenRefreshUseCase(
    private val queryRefreshTokenPort: QueryRefreshTokenPort,
    private val userSecurityPort: UserSecurityPort,
    private val userJwtPort: UserJwtPort,
    private val commandRefreshPort: CommandRefreshPort
) : TokenRefreshPort {

    override fun execute(token: String): TokenResponse {
        val refreshToken = queryRefreshTokenPort.queryRefreshTokenByToken(token)

        val user = userSecurityPort.getCurrentUser()

        val tokenResponse = userJwtPort.provideBothToken(user.accountId, user.role)

        commandRefreshPort.saveRefreshToken(
            refreshToken.updateToken(
                tokenResponse.refreshToken,
                tokenResponse.accessTokenExp.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli()
            )
        )

        return TokenResponse(
            tokenResponse.accessToken,
            tokenResponse.refreshToken,
            tokenResponse.accessTokenExp
        )
    }
}