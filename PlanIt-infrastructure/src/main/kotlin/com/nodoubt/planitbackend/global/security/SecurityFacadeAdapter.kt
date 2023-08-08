package com.nodoubt.planitbackend.global.security

import com.nodoubt.planitbackend.domain.user.domain.User
import com.nodoubt.planitbackend.domain.user.mapper.UserMapper
import com.nodoubt.planitbackend.domain.user.persistence.UserRepository
import com.nodoubt.planitbackend.domain.user.spi.UserSecurityPort
import com.nodoubt.planitbackend.global.annotation.Adapter
import com.nodoubt.planitbackend.global.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder

@Adapter
class SecurityFacadeAdapter(
    private val passwordEncoder: PasswordEncoder,
    private val userMapper: UserMapper,
    private val userRepository: UserRepository
) : UserSecurityPort {

    override fun encodePassword(password: String): String =
        passwordEncoder.encode(password)

    override fun matches(rawPassword: String, encodedPassword: String): Boolean =
        passwordEncoder.matches(rawPassword, encodedPassword)

    override fun getCurrentUser(): User {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return userMapper.toDomain(userRepository.findByAccountId(accountId) ?: throw UserNotFoundException)
    }
}