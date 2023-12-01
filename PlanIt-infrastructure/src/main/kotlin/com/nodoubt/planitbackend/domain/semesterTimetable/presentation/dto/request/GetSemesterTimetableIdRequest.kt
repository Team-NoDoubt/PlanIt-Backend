package com.nodoubt.planitbackend.domain.semesterTimetable.presentation.dto.request

import javax.validation.constraints.NotBlank

class GetSemesterTimetableIdRequest (

    @NotBlank
    val weekOfDate: Int,

    @NotBlank
    val period: Int,

    @NotBlank
    val grade: Int,

    @NotBlank
    val classNum: Int
)