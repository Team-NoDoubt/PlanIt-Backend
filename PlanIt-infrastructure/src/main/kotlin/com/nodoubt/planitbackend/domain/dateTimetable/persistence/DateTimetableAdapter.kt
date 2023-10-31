package com.nodoubt.planitbackend.domain.dateTimetable.persistence

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.changeMaster.persistence.entity.QChangeMasterEntity.changeMasterEntity
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.entity.QDateTimetableEntity.dateTimetableEntity
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.vo.QQueryChangedTimetableVO
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.vo.QQueryDateTimetableVO
import com.nodoubt.planitbackend.domain.dateTimetable.spi.DateTimetablePort
import com.nodoubt.planitbackend.domain.dateTimetable.spi.vo.ChangedTimetableVO
import com.nodoubt.planitbackend.domain.dateTimetable.spi.vo.DateTimetableVO
import com.nodoubt.planitbackend.domain.replacementClass.persistence.entity.QReplacementClassEntity.replacementClassEntity
import com.nodoubt.planitbackend.domain.semesterTimetable.persistence.entity.QSemesterTimetableEntity
import com.nodoubt.planitbackend.domain.teacher.persistence.entity.QTeacherEntity
import com.nodoubt.planitbackend.global.annotation.Adapter
import com.querydsl.jpa.impl.JPAQueryFactory
import java.time.LocalDate

@Adapter
class DateTimetableAdapter(
    private val jpaQueryFactory: JPAQueryFactory,
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
        val requestTimetableEntity = QSemesterTimetableEntity("requestTimetableEntity")
        val changeTimetableEntity = QSemesterTimetableEntity("changeTimetableEntity")
        val requestUser = QTeacherEntity("requestUser")
        val changeUser = QTeacherEntity("changeUser")

        return jpaQueryFactory
            .select(
                QQueryChangedTimetableVO(
                    replacementClassEntity.requestTimetableDate,
                    requestTimetableEntity.period,
                    requestTimetableEntity.subject,
                    requestUser.userEntity.name,
                    replacementClassEntity.changeTimetableDate,
                    changeTimetableEntity.period,
                    changeTimetableEntity.subject,
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
                        (replacementClassEntity.requestTimetableDate.between(monday, friday))
                            .or(replacementClassEntity.changeTimetableDate.between(monday, friday))
                    )
            )
            .fetch()
    }
}