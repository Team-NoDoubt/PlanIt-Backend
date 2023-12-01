package com.nodoubt.planitbackend.domain.reinforecementClass.persistence.vo

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.changeMaster.spi.reinforcementClassSpi.vo.RequestedReinforcementClassDetailsVO
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDate

class QueryRequestedReinforcementClassDetailsVO @QueryProjection constructor(
    timetableDate: LocalDate,
    period: Int,
    grade: Int,
    classNum: Int,
    subject: String,
    reinforcementPlan: String,
    reinforcementTeacher: String,
    status: Status,
    reasonRejected: String?
) : RequestedReinforcementClassDetailsVO(
    timetableDate = timetableDate,
    period = period,
    grade = grade,
    classNum = classNum,
    subject = subject,
    reinforcementPlan = reinforcementPlan,
    reinforcementTeacher = reinforcementTeacher,
    status = status,
    reasonRejected = reasonRejected
)