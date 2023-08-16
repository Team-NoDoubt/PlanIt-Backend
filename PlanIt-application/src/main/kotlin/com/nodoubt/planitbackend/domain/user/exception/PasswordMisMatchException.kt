package com.nodoubt.planitbackend.domain.user.exception

import com.nodoubt.planitbackend.domain.user.error.UserErrorCode
import com.nodoubt.planitbackend.error.PlanItException

object PasswordMisMatchException : PlanItException (
    UserErrorCode.PASSWORD_MIS_MATCH
)