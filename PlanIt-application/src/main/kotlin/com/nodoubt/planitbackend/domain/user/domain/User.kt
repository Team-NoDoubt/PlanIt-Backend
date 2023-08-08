package com.nodoubt.planitbackend.domain.user.domain

import com.nodoubt.planitbackend.annotation.Aggregate

@Aggregate
class User (
    val id: Long = 0,

    val accountId: String,

    val password: String,

    val name: String,

    val role: UserRole
)