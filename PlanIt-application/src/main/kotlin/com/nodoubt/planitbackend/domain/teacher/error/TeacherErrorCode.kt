package com.nodoubt.planitbackend.domain.teacher.error

import com.nodoubt.planitbackend.error.ErrorProperty

enum class TeacherErrorCode (
    override val status: Int,
    override val message: String
) : ErrorProperty {

    TEACHER_NOT_FOUND(404, "Teacher Not Found")
}