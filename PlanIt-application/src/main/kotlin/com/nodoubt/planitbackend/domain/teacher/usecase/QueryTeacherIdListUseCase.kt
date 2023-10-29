package com.nodoubt.planitbackend.domain.teacher.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.teacher.api.QueryTeacherIdListPort
import com.nodoubt.planitbackend.domain.teacher.api.response.QueryTeacherIdListResponse
import com.nodoubt.planitbackend.domain.teacher.api.response.TeacherIdResponse
import com.nodoubt.planitbackend.domain.teacher.spi.QueryTeacherPort

@UseCase
open class QueryTeacherIdListUseCase(
    private val queryTeacherPort: QueryTeacherPort
) : QueryTeacherIdListPort {

    override fun execute(): QueryTeacherIdListResponse {
        val teacherList = queryTeacherPort.queryAllTeacherList()

        return QueryTeacherIdListResponse(
            teacherIdList = teacherList.map {
                TeacherIdResponse(
                    teacherId = it.teacherId,
                    teacherName = it.teacherName
                )
            }
        )
    }
}