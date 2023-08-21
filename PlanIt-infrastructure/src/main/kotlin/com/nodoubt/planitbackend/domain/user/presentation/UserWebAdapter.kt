package com.nodoubt.planitbackend.domain.user.presentation

import com.nodoubt.planitbackend.domain.user.api.SignInPort
import com.nodoubt.planitbackend.domain.user.api.TokenRefreshPort
import com.nodoubt.planitbackend.domain.user.api.dto.request.DomainSignInRequest
import com.nodoubt.planitbackend.domain.user.api.dto.response.SignInResponse
import com.nodoubt.planitbackend.domain.user.api.dto.response.TokenResponse
import com.nodoubt.planitbackend.domain.user.presentation.dto.request.WebSignInRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/user")
@RestController
class UserWebAdapter (
    private val signInPort: SignInPort,
    private val tokenRefreshPort: TokenRefreshPort
) {

    @PostMapping("/auth")
    fun signIn(@RequestBody @Valid request: WebSignInRequest): SignInResponse {
        return signInPort.signIn(
            DomainSignInRequest(
                accountId = request.accountId,
                password = request.password
            )
        )
    }

    @PutMapping("/token")
    fun reIssue(@RequestHeader("REFRESH-TOKEN") refreshToken: String): TokenResponse =
        tokenRefreshPort.execute(refreshToken)

}