package com.nodoubt.planitbackend.domain.semesterTimetable.persistence.entity

import com.nodoubt.planitbackend.domain.teacher.persistence.entity.TeacherEntity
import com.nodoubt.planitbackend.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "tbl_semesterTimetable")
class SemesterTimetableEntity(

    id: Long,

    year: Int,

    semester: Int,

    grade: Int,

    classNum: Int,

    period: Int,

    weekOfDate: Int,

    subject: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    val teacherEntity: TeacherEntity,

    ) : BaseIDEntity(id) {

    @Column(columnDefinition = "VARCHAR(4)")
    @field:NotNull
    var year = year
        protected set

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var semester = semester
        protected set

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var grade = grade
        protected set

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var classNum = classNum
        protected set

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var period = period
        protected set

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var weekOfDate = weekOfDate
        protected set

    @Column(columnDefinition = "VARCHAR(30)")
    @field:NotNull
    var subject = subject
        protected set
}