package com.nodoubt.planitbackend.domain.user.persistence

import com.nodoubt.planitbackend.domain.user.persistence.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Long> {

    fun findByAccountId(accountId: String): UserEntity?
}