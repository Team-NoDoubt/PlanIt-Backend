package com.nodoubt.planitbackend.domain.user.api

import com.nodoubt.planitbackend.domain.user.api.dto.request.DomainSignInRequest
import com.nodoubt.planitbackend.domain.user.api.dto.response.SignInResponse

interface SignInPort {

    fun signIn(request: DomainSignInRequest): SignInResponse
}