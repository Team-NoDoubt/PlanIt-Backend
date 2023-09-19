package com.nodoubt.planitbackend.domain.changeMaster.spi

import com.nodoubt.planitbackend.domain.changeMaster.domain.ChangeMaster

interface CommandChangeMasterPort {
    fun saveChangeMaster(changeMaster: ChangeMaster): Long
}