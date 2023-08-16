package com.nodoubt.planitbackend.domain.user.spi

import com.nodoubt.planitbackend.domain.user.domain.User

interface QueryUserPort {

    fun queryUserByAccountId(accountId: String): User
}