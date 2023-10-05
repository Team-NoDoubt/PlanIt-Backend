package com.nodoubt.planitbackend.domain.replacementClass.spi

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.replacementClass.spi.vo.ReplacementClassDetailsVO
import com.nodoubt.planitbackend.domain.replacementClass.spi.vo.ReplacementClassListVO

interface QueryReplacementClassPort {
    fun queryReplacementClassListByUserId(userId: Long, status: Status?): List<ReplacementClassListVO>
    fun queryReplacementClassDetailsById(replacementClassId: Long): ReplacementClassDetailsVO?
}