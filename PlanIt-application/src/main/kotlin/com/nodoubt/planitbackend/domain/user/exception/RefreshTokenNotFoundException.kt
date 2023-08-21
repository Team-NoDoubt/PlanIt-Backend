package com.nodoubt.planitbackend.domain.user.exception

import com.nodoubt.planitbackend.domain.user.error.UserErrorCode
import com.nodoubt.planitbackend.error.PlanItException

object RefreshTokenNotFoundException : PlanItException(
    UserErrorCode.REFRESH_TOKEN_NOT_FOUND
)