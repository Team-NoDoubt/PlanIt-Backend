package com.nodoubt.planitbackend.domain.replacementClass.spi

import com.nodoubt.planitbackend.domain.replacementClass.domain.ReplacementClass

interface CommandReplacementPort {
    fun saveReplacementClassList(replacementClass: List<ReplacementClass>)
}