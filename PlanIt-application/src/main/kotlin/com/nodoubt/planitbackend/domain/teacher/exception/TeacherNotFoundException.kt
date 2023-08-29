package com.nodoubt.planitbackend.domain.teacher.exception

import com.nodoubt.planitbackend.domain.teacher.error.TeacherErrorCode
import com.nodoubt.planitbackend.error.PlanItException

object TeacherNotFoundException : PlanItException (
    TeacherErrorCode.TEACHER_NOT_FOUND
)