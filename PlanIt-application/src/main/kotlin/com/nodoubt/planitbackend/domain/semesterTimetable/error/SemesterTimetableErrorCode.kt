package com.nodoubt.planitbackend.domain.semesterTimetable.error

import com.nodoubt.planitbackend.error.ErrorProperty

enum class SemesterTimetableErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    SEMESTER_TIMETABLE_NOT_FOUND(404, "Semester Timetable Not Found")
}