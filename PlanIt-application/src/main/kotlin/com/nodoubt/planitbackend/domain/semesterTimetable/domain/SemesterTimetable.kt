package com.nodoubt.planitbackend.domain.semesterTimetable.domain

import com.nodoubt.planitbackend.annotation.Aggregate

@Aggregate
class SemesterTimetable (
    val id: Long,

    val year: Int,

    val semester: Int,

    val grade: Int,

    val classNum: Int,

    val period: Int,

    val weekOfDate: Int,

    val subject: String,

    val teacherId: Long
)