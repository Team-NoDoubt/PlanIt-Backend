package com.nodoubt.planitbackend.domain.teacher.persistence.vo

import com.nodoubt.planitbackend.domain.teacher.spi.vo.AllTeacherListVO
import com.querydsl.core.annotations.QueryProjection

class QueryAllTeacherListVO @QueryProjection constructor(
    teacherId: Long,
    teacherName: String
) : AllTeacherListVO(
    teacherId = teacherId,
    teacherName = teacherName
)