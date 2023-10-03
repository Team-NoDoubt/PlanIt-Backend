package com.nodoubt.planitbackend.domain.reinforecementClass.persistence.entity

import com.nodoubt.planitbackend.domain.changeMaster.persistence.entity.ChangeMasterEntity
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.entity.DateTimetableEntity
import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.semesterTimetable.persistence.entity.SemesterTimetableEntity
import com.nodoubt.planitbackend.domain.teacher.persistence.entity.TeacherEntity
import com.nodoubt.planitbackend.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
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

    reasonRejected: String?,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semesterTimetable_id", nullable = false)
    val semesterTimetableEntity: SemesterTimetableEntity,

    timetableDate: LocalDate,

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

    @field:NotNull
    var timetableDate = timetableDate
        protected set
}