package com.nodoubt.planitbackend.domain.semesterTimetable.spi

import com.nodoubt.planitbackend.domain.semesterTimetable.domain.SemesterTimetable

interface QuerySemesterTimetablePort {
    fun querySemesterTimetableIdByWeekOfDateAndPeriodAndGradeAndClassNum(weekOfDate: Int, grade: Int, classNum: Int, period: Int): SemesterTimetable
}