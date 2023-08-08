package com.nodoubt.planitbackend.domain.user.spi.dto

import java.time.LocalDateTime

class SpiTokenResponse (

    val accessToken: String,

    val refreshToken: String,

    val accessTokenExp: LocalDateTime
)