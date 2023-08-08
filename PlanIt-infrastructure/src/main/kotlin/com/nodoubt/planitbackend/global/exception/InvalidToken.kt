package com.nodoubt.planitbackend.global.exception

import com.nodoubt.planitbackend.error.PlanItException
import com.nodoubt.planitbackend.global.error.ErrorCode

object InvalidToken: PlanItException (
    ErrorCode.INVALID_TOKEN
)