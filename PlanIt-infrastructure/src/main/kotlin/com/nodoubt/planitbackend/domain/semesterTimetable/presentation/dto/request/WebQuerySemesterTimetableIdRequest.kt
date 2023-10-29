package com.nodoubt.planitbackend.domain.semesterTimetable.presentation.dto.request

import javax.validation.constraints.NotBlank

class WebQuerySemesterTimetableIdRequest (

    @NotBlank
    val weekOfDate: Int,

    @NotBlank
    val grade: Int,

    @NotBlank
    val classNum: Int,

    @NotBlank
    val period: Int
)