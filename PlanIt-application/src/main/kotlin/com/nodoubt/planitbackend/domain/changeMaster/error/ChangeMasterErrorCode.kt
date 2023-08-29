package com.nodoubt.planitbackend.domain.changeMaster.error

import com.nodoubt.planitbackend.error.ErrorProperty

enum class ChangeMasterErrorCode (
    override val status: Int,
    override val message: String
) : ErrorProperty {

    CHANGE_MASTER_NOT_FOUND(404, "Change Master Not Found")
}