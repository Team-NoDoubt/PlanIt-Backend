package com.nodoubt.planitbackend.domain.user.api

import com.nodoubt.planitbackend.domain.user.api.dto.response.TokenResponse

interface TokenRefreshPort {

    fun execute(token: String): TokenResponse
}