package com.nodoubt.planitbackend.domain.replacementClass.persistence.vo

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.replacementClass.spi.vo.ReplacementClassListVO
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDate

class QueryReplacementClassListVO @QueryProjection constructor(
    id: Long,
    status: Status,
    teacherName: String,
    requestDate: LocalDate,
) : ReplacementClassListVO(
    id = id,
    status = status,
    teacherName = teacherName,
    requestDate = requestDate,
)