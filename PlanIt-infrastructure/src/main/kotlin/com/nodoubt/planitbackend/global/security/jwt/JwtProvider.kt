package com.nodoubt.planitbackend.global.security.jwt

import com.nodoubt.planitbackend.domain.user.domain.UserRole
import com.nodoubt.planitbackend.domain.user.spi.UserJwtPort
import com.nodoubt.planitbackend.domain.user.spi.dto.SpiTokenResponse
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtProvider(
    private val securityProperties: SecurityProperties
) : UserJwtPort {

    private fun createAccessToken(accountId: String, role: UserRole) =
        generateToken(accountId, role, JwtProperties.ACCESS, securityProperties.accessExp)

    private fun createRefreshToken(accountId: String, role: UserRole) =
        generateToken(accountId, role, JwtProperties.REFRESH, securityProperties.refreshExp)

    private fun generateToken(accountId: String, role: UserRole, type: String, ttl: Long) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
            .setSubject(accountId)
            .setHeaderParam("type", "jwt")
            .claim("role", role)
            .claim("type", type)
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
            .compact()

    override fun provideBothToken(accountId: String, role: UserRole) = SpiTokenResponse(
        accessToken = createAccessToken(accountId, role),
        refreshToken = createRefreshToken(accountId, role),
        accessTokenExp = LocalDateTime.now().plusSeconds(securityProperties.accessExp)
    )
}