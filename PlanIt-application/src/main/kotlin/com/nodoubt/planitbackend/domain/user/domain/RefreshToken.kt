package com.nodoubt.planitbackend.domain.user.domain

import com.nodoubt.planitbackend.annotation.Aggregate

@Aggregate
class RefreshToken(

    val id: String,

    var refreshToken: String,

    var ttl: Long
) {
    fun updateToken(refreshToken: String, ttl: Long): RefreshToken {
        return RefreshToken(
            id = this.id,
            refreshToken = refreshToken,
            ttl = ttl
        )
    }
}