package com.nodoubt.planitbackend.global.exception

import com.nodoubt.planitbackend.error.PlanItException
import com.nodoubt.planitbackend.global.error.ErrorCode

object UserNotFoundException: PlanItException (
    ErrorCode.USER_NOT_FOUND
)