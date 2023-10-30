package com.nodoubt.planitbackend.domain.changeMaster.api

import com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.DomainChangeTimetableRequest

interface ChangeTimetablePort {

    fun execute(request: DomainChangeTimetableRequest)
}