package com.nodoubt.planitbackend.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.nodoubt.planitbackend.global.filter.FilterConfig
import com.nodoubt.planitbackend.global.security.jwt.JwtParser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val jwtParser: JwtParser,
    private val objectMapper: ObjectMapper
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .formLogin().disable()
            .cors()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http
            .authorizeRequests()

            .antMatchers(HttpMethod.POST, "/post").authenticated()
            .antMatchers(HttpMethod.GET, "/replacement-class").authenticated()
            .antMatchers(HttpMethod.GET, "/replacement-class/{replacement-class-id}").authenticated()

            .anyRequest().permitAll()
            .and().apply(FilterConfig(jwtParser, objectMapper))

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}