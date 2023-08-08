package com.nodoubt.planitbackend.domain.user.mapper

import com.nodoubt.planitbackend.domain.user.domain.RefreshToken
import com.nodoubt.planitbackend.domain.user.persistence.entity.RefreshTokenEntity
import com.nodoubt.planitbackend.global.entity.GenericMapper
import org.springframework.stereotype.Component

@Component
class RefreshTokenMapper : GenericMapper<RefreshToken, RefreshTokenEntity> {

    override fun toDomain(entity: RefreshTokenEntity): RefreshToken = entity.let {
        RefreshToken(
            id = it.id,
            refreshToken = it.refreshToken,
            ttl = it.ttl
        )
    }


    override fun toEntity(domain: RefreshToken): RefreshTokenEntity = domain.let {
        RefreshTokenEntity(
            id = it.id,
            refreshToken = it.refreshToken,
            ttl = it.ttl
        )
    }
}