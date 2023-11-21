package com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi

import com.nodoubt.planitbackend.domain.changeMaster.domain.ReplacementClass

interface CommandReplacementPort {
    fun saveReplacementClassList(replacementClass: List<ReplacementClass>)
}