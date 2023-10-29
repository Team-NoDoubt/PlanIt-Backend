package com.nodoubt.planitbackend.domain.teacher.api

import com.nodoubt.planitbackend.domain.teacher.api.response.QueryTeacherIdListResponse

interface QueryTeacherIdListPort {
    fun execute(): QueryTeacherIdListResponse
}