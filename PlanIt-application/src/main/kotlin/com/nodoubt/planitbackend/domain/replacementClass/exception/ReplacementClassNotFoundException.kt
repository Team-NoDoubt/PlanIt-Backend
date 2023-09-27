package com.nodoubt.planitbackend.domain.replacementClass.exception

import com.nodoubt.planitbackend.domain.replacementClass.error.ReplacementClassErrorCode
import com.nodoubt.planitbackend.error.PlanItException

object ReplacementClassNotFoundException : PlanItException(
    ReplacementClassErrorCode.REPLACEMENT_CLASS_NOT_FOUND
)