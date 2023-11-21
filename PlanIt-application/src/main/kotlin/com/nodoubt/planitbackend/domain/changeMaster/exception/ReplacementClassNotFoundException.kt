package com.nodoubt.planitbackend.domain.changeMaster.exception

import com.nodoubt.planitbackend.domain.changeMaster.error.ChangeMasterErrorCode
import com.nodoubt.planitbackend.error.PlanItException

object ReplacementClassNotFoundException : PlanItException(
    ChangeMasterErrorCode.REPLACEMENT_CLASS_NOT_FOUND
)