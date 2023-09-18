package com.nodoubt.planitbackend.domain.reinforecementClass.persistence.entity

import com.nodoubt.planitbackend.domain.changeMaster.persistence.entity.ChangeMasterEntity
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.entity.DateTimetableEntity
import com.nodoubt.planitbackend.domain.reinforcementClass.domain.Status
import com.nodoubt.planitbackend.domain.teacher.persistence.entity.TeacherEntity
import com.nodoubt.planitbackend.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "tbl_reinforcementClass")
class ReinforcementClassEntity (

    id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changeMaster_id", nullable = false)
    val changeMasterEntity: ChangeMasterEntity,

    status: Status,

    reinforcementPlan: String,

    reasonRejected: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dataTimetable_id", nullable = false)
    val dateTimetableEntity: DateTimetableEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    val teacherEntity: TeacherEntity

) : BaseIDEntity(id) {

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    @field:NotNull
    var status = status
        protected set

    @Column(columnDefinition = "VARCHAR(20)")
    @field:NotNull
    var reinforcementPlan = reinforcementPlan
        protected set

    @Column(columnDefinition = "VARCHAR(20)")
    var reasonRejected = reasonRejected
        protected set
}