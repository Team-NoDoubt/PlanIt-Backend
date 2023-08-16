package com.nodoubt.planitbackend.domain.user.error

import com.nodoubt.planitbackend.error.ErrorProperty

enum class UserErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    PASSWORD_MIS_MATCH(400, "Password Mis Match"),
}