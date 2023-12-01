package com.nodoubt.planitbackend.domain.dateTimetable.domain

import com.nodoubt.planitbackend.annotation.Aggregate
import java.time.LocalDate

@Aggregate
class DateTimetable(

    val id: Long,

    val year: Int,

    val semester: Int,

    val date: LocalDate,

    val grade: Int,

    val classNum: Int,

    val period: Int,

    val weekOfDate: Int,

    val subject: String,

    val teacherId: Long
)