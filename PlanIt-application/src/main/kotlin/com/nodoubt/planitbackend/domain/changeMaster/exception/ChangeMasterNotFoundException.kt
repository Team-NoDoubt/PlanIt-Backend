package com.nodoubt.planitbackend.domain.changeMaster.exception

import com.nodoubt.planitbackend.domain.changeMaster.error.ChangeMasterErrorCode
import com.nodoubt.planitbackend.error.PlanItException

object ChangeMasterNotFoundException : PlanItException(
    ChangeMasterErrorCode.CHANGE_MASTER_NOT_FOUND
)