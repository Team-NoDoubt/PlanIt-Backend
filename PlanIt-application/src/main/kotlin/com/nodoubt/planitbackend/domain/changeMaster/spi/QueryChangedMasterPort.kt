package com.nodoubt.planitbackend.domain.changeMaster.spi

import com.nodoubt.planitbackend.domain.changeMaster.domain.ChangeMaster

interface QueryChangedMasterPort {
    fun queryRequestedTimetableByUserId(teacherId: Long): List<ChangeMaster>
}