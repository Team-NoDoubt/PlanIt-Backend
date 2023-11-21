package com.nodoubt.planitbackend.domain.changeMaster.api.dto.response

import com.nodoubt.planitbackend.domain.changeMaster.spi.replacementClassSpi.vo.ReplacementClassListVO

data class QueryReplacementClassListResponse(
    val replacementClassList: List<ReplacementClassListVO>
)
