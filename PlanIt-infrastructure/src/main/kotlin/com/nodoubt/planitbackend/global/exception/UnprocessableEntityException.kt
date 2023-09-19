package com.nodoubt.planitbackend.global.exception

import com.nodoubt.planitbackend.error.PlanItException
import com.nodoubt.planitbackend.global.error.ErrorCode

object UnprocessableEntityException : PlanItException(ErrorCode.UNPROCESSABLE_ENTITY)