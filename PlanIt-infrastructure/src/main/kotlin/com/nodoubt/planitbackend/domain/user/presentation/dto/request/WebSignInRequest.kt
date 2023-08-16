package com.nodoubt.planitbackend.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

class WebSignInRequest (

    @NotBlank
    val accountId: String,

    @NotBlank
    val password: String
)