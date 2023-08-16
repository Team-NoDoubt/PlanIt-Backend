package com.nodoubt.planitbackend.domain.user.spi

import com.nodoubt.planitbackend.domain.user.domain.RefreshToken

interface CommandRefreshPort {

    fun saveRefreshToken(refreshToken: RefreshToken)
}