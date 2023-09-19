package com.nodoubt.planitbackend.domain.changeMaster.api

import com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.ChangeTimetableRequest

interface ChangeTimetablePort {

    fun execute(request: ChangeTimetableRequest)
}