package com.nodoubt.planitbackend.domain.dateTimetable.persistence

import com.nodoubt.planitbackend.domain.dateTimetable.mapper.DateTimetableMapper
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.entity.QDateTimetableEntity.dateTimetableEntity
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.vo.QQueryDateTimetableVO
import com.nodoubt.planitbackend.domain.dateTimetable.spi.DateTimetablePort
import com.nodoubt.planitbackend.domain.dateTimetable.spi.vo.DateTimetableVO
import com.nodoubt.planitbackend.global.annotation.Adapter
import com.querydsl.jpa.impl.JPAQueryFactory
import java.time.LocalDate

@Adapter
class DateTimetableAdapter (
    private val jpaQueryFactory: JPAQueryFactory,
    private val dateTimetableRepository: DateTimetableRepository,
    private val dateTimetableMapper: DateTimetableMapper
) : DateTimetablePort {

    override fun queryDateTimetableList(grade: Int, classNum: Int, monday: LocalDate, friday: LocalDate): List<DateTimetableVO> =
        jpaQueryFactory
            .select(
                QQueryDateTimetableVO(
                    dateTimetableEntity.grade,
                    dateTimetableEntity.classNum,
                    dateTimetableEntity.period,
                    dateTimetableEntity.weekOfDate,
                    dateTimetableEntity.subject
                )
            )
            .from(dateTimetableEntity)
            .where(
                dateTimetableEntity.grade.eq(grade)
                    .and(dateTimetableEntity.classNum.eq(classNum))
                    .and(dateTimetableEntity.date.between(monday, friday))
            )
            .orderBy(dateTimetableEntity.weekOfDate.asc(), dateTimetableEntity.period.asc())
            .fetch()
}