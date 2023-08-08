package com.nodoubt.planitbackend.global.security.jwt

import com.nodoubt.planitbackend.global.exception.ExpiredToken
import com.nodoubt.planitbackend.global.exception.InternalServerError
import com.nodoubt.planitbackend.global.exception.InvalidToken
import com.nodoubt.planitbackend.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)
        val accountId = claims.subject
        val authDetails = authDetailsService.loadUserByUsername(accountId)

        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(securityProperties.secretKey)
                .parseClaimsJws(token)
                .body
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw InvalidToken
                is ExpiredJwtException -> throw ExpiredToken
                else -> throw InternalServerError
            }
        }
    }

}