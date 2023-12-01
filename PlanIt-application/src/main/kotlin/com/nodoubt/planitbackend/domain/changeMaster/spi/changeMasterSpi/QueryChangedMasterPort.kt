package com.nodoubt.planitbackend.domain.changeMaster.spi.changeMasterSpi

import com.nodoubt.planitbackend.domain.changeMaster.domain.ChangeMaster

interface QueryChangedMasterPort {
    fun queryRequestedTimetableByUserId(teacherId: Long): List<ChangeMaster>
    fun queryChangedMasterDetailsById(changeMasterId: Long): ChangeMaster
}