package com.nodoubt.planitbackend.domain.changeMaster.spi.reinforcementClassSpi

import com.nodoubt.planitbackend.domain.changeMaster.domain.ReinforcementClass

interface CommandReinforcementPort {

    fun saveReinforcementClassList(reinforcementClass: List<ReinforcementClass>)
}