package com.nodoubt.planitbackend.domain.user.spi

import com.nodoubt.planitbackend.domain.user.domain.UserRole
import com.nodoubt.planitbackend.domain.user.spi.dto.SpiTokenResponse

interface UserJwtPort {

    fun provideBothToken(accountId: String, role: UserRole): SpiTokenResponse
}