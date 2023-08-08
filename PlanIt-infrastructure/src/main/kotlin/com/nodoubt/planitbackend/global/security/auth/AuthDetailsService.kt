package com.nodoubt.planitbackend.global.security.auth

import com.nodoubt.planitbackend.domain.user.persistence.UserRepository
import com.nodoubt.planitbackend.global.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService (
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        val user = userRepository.findByAccountId(accountId)
            ?: throw UserNotFoundException

        return AuthDetails(user)
    }
}