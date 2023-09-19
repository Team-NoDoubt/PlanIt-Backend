package com.nodoubt.planitbackend.domain.reinforcementClass.spi

import com.nodoubt.planitbackend.domain.reinforcementClass.domain.ReinforcementClass

interface CommandReinforcementPort {

    fun saveReinforcementClassList(reinforcementClass: List<ReinforcementClass>)
}