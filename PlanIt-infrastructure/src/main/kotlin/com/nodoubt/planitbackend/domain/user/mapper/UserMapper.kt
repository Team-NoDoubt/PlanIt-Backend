package com.nodoubt.planitbackend.domain.user.mapper

import com.nodoubt.planitbackend.domain.user.domain.User
import com.nodoubt.planitbackend.domain.user.persistence.entity.UserEntity
import com.nodoubt.planitbackend.global.entity.GenericMapper
import org.springframework.stereotype.Component

@Component
class UserMapper : GenericMapper<User, UserEntity> {

    override fun toDomain(entity: UserEntity): User = entity.let {
        User(
            id = it.id,
            accountId = it.accountId,
            password = it.password,
            name = it.name,
            role = it.role
        )
    }

    override fun toEntity(domain: User): UserEntity = domain.let {
        UserEntity(
            id = it.id,
            accountId = it.accountId,
            password = it.password,
            name = it.name,
            role = it.role
        )
    }
}