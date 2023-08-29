package com.nodoubt.planitbackend.domain.dateTimetable.exception

import com.nodoubt.planitbackend.domain.dateTimetable.error.DateTimetableErrorCode
import com.nodoubt.planitbackend.error.PlanItException

object DateTimetableNotFoundException : PlanItException (
    DateTimetableErrorCode.TIMETABLE_NOT_FOUND
)