package com.nodoubt.planitbackend.domain.user.spi

import com.nodoubt.planitbackend.domain.user.domain.User

interface UserSecurityPort {

    fun encodePassword(password: String): String

    fun matches(rawPassword: String, encodedPassword: String): Boolean

    fun getCurrentUser(): User
}