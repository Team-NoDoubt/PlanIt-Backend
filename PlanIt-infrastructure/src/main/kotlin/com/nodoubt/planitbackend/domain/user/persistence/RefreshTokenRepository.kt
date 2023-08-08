package com.nodoubt.planitbackend.domain.user.persistence

import com.nodoubt.planitbackend.domain.user.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {

    fun findByRefreshToken(refreshToken: String): RefreshTokenEntity?
}