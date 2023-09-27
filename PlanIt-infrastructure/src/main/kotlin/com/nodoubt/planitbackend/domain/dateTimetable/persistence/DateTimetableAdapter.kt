package com.nodoubt.planitbackend.domain.dateTimetable.persistence

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.changeMaster.persistence.entity.QChangeMasterEntity.changeMasterEntity
import com.nodoubt.planitbackend.domain.dateTimetable.mapper.DateTimetableMapper
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.entity.QDateTimetableEntity
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.entity.QDateTimetableEntity.dateTimetableEntity
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.vo.QQueryChangedTimetableVO
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.vo.QQueryDateTimetableVO
import com.nodoubt.planitbackend.domain.dateTimetable.spi.DateTimetablePort
import com.nodoubt.planitbackend.domain.dateTimetable.spi.vo.ChangedTimetableVO
import com.nodoubt.planitbackend.domain.dateTimetable.spi.vo.DateTimetableVO
import com.nodoubt.planitbackend.domain.replacementClass.persistence.entity.QReplacementClassEntity.replacementClassEntity
import com.nodoubt.planitbackend.domain.teacher.persistence.entity.QTeacherEntity
import com.nodoubt.planitbackend.global.annotation.Adapter
import com.querydsl.jpa.impl.JPAQueryFactory
import java.time.LocalDate

@Adapter
class DateTimetableAdapter(
    private val jpaQueryFactory: JPAQueryFactory,
    private val dateTimetableRepository: DateTimetableRepository,
    private val dateTimetableMapper: DateTimetableMapper
) : DateTimetablePort {

    override fun queryDateTimetableList(
        grade: Int,
        classNum: Int,
        monday: LocalDate,
        friday: LocalDate
    ): List<DateTimetableVO> =
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

    override fun queryChangedTimetableList(
        grade: Int,
        classNum: Int,
        monday: LocalDate,
        friday: LocalDate
    ): List<ChangedTimetableVO> {
        val requestTimetableEntity = QDateTimetableEntity("requestTimetableEntity")
        val changeTimetableEntity = QDateTimetableEntity("changeTimetableEntity")
        val requestUser = QTeacherEntity("requestUser")
        val changeUser = QTeacherEntity("changeUser")

        return jpaQueryFactory
            .select(
                QQueryChangedTimetableVO(
                    requestTimetableEntity.date,
                    requestTimetableEntity.period,
                    changeTimetableEntity.subject,
                    requestUser.userEntity.name,
                    changeTimetableEntity.date,
                    changeTimetableEntity.period,
                    requestTimetableEntity.subject,
                    changeUser.userEntity.name
                )
            )
            .from(changeMasterEntity)
            .join(replacementClassEntity).on(changeMasterEntity.id.eq(replacementClassEntity.changeMasterEntity.id))
            .join(replacementClassEntity.requestTimetableEntity, requestTimetableEntity)
            .join(replacementClassEntity.changeTimetableEntity, changeTimetableEntity)
            .join(requestTimetableEntity.teacherEntity, requestUser)
            .join(changeTimetableEntity.teacherEntity, changeUser)
            .where(
                changeMasterEntity.status.eq(Status.ACCEPT)
                    .and(
                        (requestTimetableEntity.date.between(monday, friday))
                            .or(changeTimetableEntity.date.between(monday, friday))
                    )
            )
            .fetch()
    }
}