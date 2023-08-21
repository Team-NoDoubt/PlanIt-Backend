package com.nodoubt.planitbackend.domain.user.persistence

import com.nodoubt.planitbackend.domain.user.domain.RefreshToken
import com.nodoubt.planitbackend.domain.user.exception.RefreshTokenNotFoundException
import com.nodoubt.planitbackend.domain.user.mapper.RefreshTokenMapper
import com.nodoubt.planitbackend.domain.user.spi.RefreshTokenPort
import com.nodoubt.planitbackend.global.annotation.Adapter

@Adapter
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper
) : RefreshTokenPort {

    override fun saveRefreshToken(refreshToken: RefreshToken) {
        refreshTokenRepository.save(refreshTokenMapper.toEntity(refreshToken))
    }

    override fun queryRefreshTokenByToken(token: String): RefreshToken =
        refreshTokenMapper.toDomain(
            refreshTokenRepository.findByRefreshToken(token) ?: throw RefreshTokenNotFoundException
        )

}