package com.nodoubt.planitbackend.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.nodoubt.planitbackend.global.security.jwt.JwtParser
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtParser: JwtParser,
    private val objectMapper: ObjectMapper
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(
            JwtTokenFilter(jwtParser),
            UsernamePasswordAuthenticationFilter::class.java
        )
        builder.addFilterBefore(
            GlobalExceptionFilter(objectMapper), JwtTokenFilter::class.java
        )
    }
}