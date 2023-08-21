package com.nodoubt.planitbackend.domain.user.spi

import com.nodoubt.planitbackend.domain.user.domain.RefreshToken

interface QueryRefreshTokenPort {

    fun queryRefreshTokenByToken(token: String): RefreshToken
}