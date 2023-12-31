package com.nodoubt.planitbackend.domain.user.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshTokenEntity(

    @Id
    val id: String,

    @Indexed
    val refreshToken: String,

    @TimeToLive
    val ttl: Long
)