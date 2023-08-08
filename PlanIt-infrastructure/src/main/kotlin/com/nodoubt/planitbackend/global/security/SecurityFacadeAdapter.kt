package com.nodoubt.planitbackend.global.security

import com.nodoubt.planitbackend.domain.user.persistence.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder

@Adapter
class SecurityFacadeAdapter(
    private val passwordEncoder: PasswordEncoder,
    private val userMapper: ,
    private val userRepository: UserRepository
) : UserSecurityPort {

    override fun encodePassword(password: String): String =
        passwordEncoder.encode(password)

    override fun matches(rawPassword: String, encodedPassword: String): Boolean =
        passwordEncoder.matches(rawPassword, encodedPassword)

    override fun getCurrentUser(): Teacher {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return teacherMapper.toDomain(teacherRepository.findByAccountId(accountId) ?: throw UserNotFoundException)
    }
}