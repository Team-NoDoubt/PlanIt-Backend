package com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi.vo

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import java.time.LocalDate

open class ReplacementClassListVO(
    val id: Long,
    val status: Status,
    val teacherName: String,
    val requestDate: LocalDate,
)
