package com.nodoubt.planitbackend.domain.changeMaster.persistence.entity

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.teacher.persistence.entity.TeacherEntity
import com.nodoubt.planitbackend.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tbl_changeMaster")
class ChangeMasterEntity(

    id: Long,

    reason: String,

    status: Status,

    date: LocalDate,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    val teacherEntity: TeacherEntity

) : BaseIDEntity(id) {

    @field:NotNull
    var reason = reason
        protected set

    @Enumerated(EnumType.STRING)
    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    var status = status
        protected set

    @field:NotNull
    var date = date
        protected set
}