package com.nodoubt.planitbackend.domain.replacementClass.error

import com.nodoubt.planitbackend.error.ErrorProperty

enum class ReplacementClassErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {

    REPLACEMENT_CLASS_NOT_FOUND(404, "Replacement Class Not Found")
}