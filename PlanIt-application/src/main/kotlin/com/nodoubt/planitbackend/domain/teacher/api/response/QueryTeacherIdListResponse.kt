package com.nodoubt.planitbackend.domain.teacher.api.response

class QueryTeacherIdListResponse (
    val teacherIdList: List<TeacherIdResponse>
)

data class TeacherIdResponse(
    val teacherId: Long,
    val teacherName: String
)