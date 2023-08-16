package com.nodoubt.planitbackend.domain.user.persistence.entity

import com.nodoubt.planitbackend.domain.user.domain.UserRole
import com.nodoubt.planitbackend.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.*

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
        protected set

    @field:NotNull
    var password = password
        protected set

    @Column(columnDefinition = "VARCHAR(5)")
    @field:NotNull
    var name = name
        protected set

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(7)")
    @field:NotNull
    var role = role
        protected set
}