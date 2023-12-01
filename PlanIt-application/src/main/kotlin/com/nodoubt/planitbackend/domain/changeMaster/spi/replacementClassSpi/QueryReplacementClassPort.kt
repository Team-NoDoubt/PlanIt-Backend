package com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi.vo.ReplacementClassDetailsVO
import com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi.vo.ReplacementClassListVO
import com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi.vo.RequestedReplacementClassDetailsVO

interface QueryReplacementClassPort {
    fun queryReplacementClassListByUserId(userId: Long, status: Status?): List<ReplacementClassListVO>
    fun queryReplacementClassDetailsById(replacementClassId: Long): ReplacementClassDetailsVO?
    fun queryReplacementClassDetailsByChangeMasterId(changeMasterId: Long): List<RequestedReplacementClassDetailsVO>
}