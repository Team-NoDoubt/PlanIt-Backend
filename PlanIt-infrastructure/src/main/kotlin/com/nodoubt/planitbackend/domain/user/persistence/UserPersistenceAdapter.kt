package com.nodoubt.planitbackend.domain.user.persistence

import com.nodoubt.planitbackend.domain.user.domain.User
import com.nodoubt.planitbackend.domain.user.mapper.UserMapper
import com.nodoubt.planitbackend.domain.user.spi.UserPort
import com.nodoubt.planitbackend.global.annotation.Adapter
import com.nodoubt.planitbackend.global.exception.UserNotFoundException

@Adapter
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserPort {

    override fun queryUserByAccountId(accountId: String): User {
        return userMapper.toDomain(
            userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
        )
    }
}