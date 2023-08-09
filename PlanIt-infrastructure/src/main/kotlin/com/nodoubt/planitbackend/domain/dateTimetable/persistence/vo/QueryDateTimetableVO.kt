package com.nodoubt.planitbackend.domain.dateTimetable.persistence.vo

import com.nodoubt.planitbackend.domain.dateTimetable.spi.vo.DateTimetableVO
import com.querydsl.core.annotations.QueryProjection

class QueryDateTimetableVO @QueryProjection constructor(

    grade: Int,

    classNum: Int,

    period: Int,

    weekOfDate: Int,

    subject: String

) : DateTimetableVO (
    grade = grade,
    classNum = classNum,
    period = period,
    weekOfDate = weekOfDate,
    subject = subject,
)