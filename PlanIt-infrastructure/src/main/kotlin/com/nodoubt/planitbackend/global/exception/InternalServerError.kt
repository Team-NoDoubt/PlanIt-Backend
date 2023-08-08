package com.nodoubt.planitbackend.global.exception

import com.nodoubt.planitbackend.error.PlanItException
import com.nodoubt.planitbackend.global.error.ErrorCode

object InternalServerError: PlanItException (
    ErrorCode.INTERNAL_SERVER_ERROR
)