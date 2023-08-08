package com.nodoubt.planitbackend.domain.user.persistence.entity

import com.nodoubt.planitbackend.domain.user.domain.UserRole
import com.nodoubt.planitbackend.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbl_user")
class UserEntity (

    id: Long,

    accountId: String,

    password: String,

    name: String,

    role: UserRole

) : BaseIDEntity(id) {

    @Column(columnDefinition = "VARCHAR(15)")
    @field:NotNull
    var accountId = accountId

    @field:NotNull
    var password = password

    @Column(columnDefinition = "VARCHAR(5)")
    @field:NotNull
    var name = name

    @Column(columnDefinition = "VARCHAR(7)")
    @field:NotNull
    var role = role
}