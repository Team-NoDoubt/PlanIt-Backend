package com.nodoubt.planitbackend.domain.teacher.presentation

import com.nodoubt.planitbackend.domain.teacher.api.QueryTeacherIdListPort
import com.nodoubt.planitbackend.domain.teacher.api.response.QueryTeacherIdListResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/teachers")
@RestController
class TeacherWebAdapter(
    private val queryTeacherIdListPort: QueryTeacherIdListPort
) {

    @GetMapping
    fun queryTeacherIdList(): QueryTeacherIdListResponse =
        queryTeacherIdListPort.execute()

}