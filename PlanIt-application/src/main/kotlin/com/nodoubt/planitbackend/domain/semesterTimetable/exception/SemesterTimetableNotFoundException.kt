package com.nodoubt.planitbackend.domain.semesterTimetable.exception

import com.nodoubt.planitbackend.domain.semesterTimetable.error.SemesterTimetableErrorCode
import com.nodoubt.planitbackend.error.PlanItException

object SemesterTimetableNotFoundException : PlanItException(
    SemesterTimetableErrorCode.SEMESTER_TIMETABLE_NOT_FOUND
)