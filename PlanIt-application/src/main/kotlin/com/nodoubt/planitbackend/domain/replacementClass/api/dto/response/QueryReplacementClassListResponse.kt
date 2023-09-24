package com.nodoubt.planitbackend.domain.replacementClass.api.dto.response

import com.nodoubt.planitbackend.domain.replacementClass.spi.vo.ReplacementClassListVO

data class QueryReplacementClassListResponse(
    val replacementClassList: List<ReplacementClassListVO>
)
