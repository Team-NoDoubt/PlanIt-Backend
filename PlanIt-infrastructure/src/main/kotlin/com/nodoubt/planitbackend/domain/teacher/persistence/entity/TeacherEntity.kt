package com.nodoubt.planitbackend.domain.teacher.persistence.entity

import com.nodoubt.planitbackend.domain.user.persistence.entity.UserEntity
import com.nodoubt.planitbackend.global.entity.BaseIDEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "tbl_teacher")
class TeacherEntity (

    id: Long,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val userEntity: UserEntity

) : BaseIDEntity(id)