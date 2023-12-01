package com.nodoubt.planitbackend.domain.changeMaster.spi.reinforcementClassSpi

import com.nodoubt.planitbackend.domain.changeMaster.spi.reinforcementClassSpi.vo.RequestedReinforcementClassDetailsVO

interface QueryReinforcementClassPort {
    fun queryReinforcementClassByChangeMasterId(changeMasterId: Long): List<RequestedReinforcementClassDetailsVO>
}