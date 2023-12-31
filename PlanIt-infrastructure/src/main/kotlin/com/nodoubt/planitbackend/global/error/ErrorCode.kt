package com.nodoubt.planitbackend.global.error

import com.nodoubt.planitbackend.error.ErrorProperty

enum class ErrorCode (
    override val status: Int,
    override val message: String
) : ErrorProperty {

    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),

    USER_NOT_FOUND(404, "User Not Found"),

    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}