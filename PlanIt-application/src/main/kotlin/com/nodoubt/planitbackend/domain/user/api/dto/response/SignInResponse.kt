package com.nodoubt.planitbackend.domain.user.api.dto.response

import java.time.LocalDateTime

class SignInResponse(

    val name: String,

    val accessToken: String,

    val refreshToken: String,

    val accessTokenExp: LocalDateTime
)