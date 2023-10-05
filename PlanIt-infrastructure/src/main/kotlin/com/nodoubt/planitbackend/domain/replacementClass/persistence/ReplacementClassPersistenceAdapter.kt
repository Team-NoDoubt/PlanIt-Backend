package com.nodoubt.planitbackend.domain.replacementClass.persistence

import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.changeMaster.persistence.entity.QChangeMasterEntity.changeMasterEntity
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.entity.QDateTimetableEntity
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.vo.QQueryDateTimetableVO
import com.nodoubt.planitbackend.domain.replacementClass.domain.ReplacementClass
import com.nodoubt.planitbackend.domain.replacementClass.mapper.ReplacementClassMapper
import com.nodoubt.planitbackend.domain.replacementClass.persistence.entity.QReplacementClassEntity.replacementClassEntity
import com.nodoubt.planitbackend.domain.replacementClass.persistence.vo.QQueryReplacementClassDetailsVO
import com.nodoubt.planitbackend.domain.replacementClass.persistence.vo.QQueryReplacementClassListVO
import com.nodoubt.planitbackend.domain.replacementClass.persistence.vo.QueryReplacementClassDetailsVO
import com.nodoubt.planitbackend.domain.replacementClass.persistence.vo.QueryReplacementClassListVO
import com.nodoubt.planitbackend.domain.replacementClass.spi.ReplacementClassPort
import com.nodoubt.planitbackend.domain.semesterTimetable.persistence.entity.QSemesterTimetableEntity
import com.nodoubt.planitbackend.domain.teacher.persistence.entity.QTeacherEntity.teacherEntity
import com.nodoubt.planitbackend.domain.user.persistence.entity.QUserEntity.userEntity
import com.nodoubt.planitbackend.global.annotation.Adapter
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory

@Adapter
class ReplacementClassPersistenceAdapter(
    private val replacementClassRepository: ReplacementClassRepository,
    private val replacementClassMapper: ReplacementClassMapper,
    private val queryFactory: JPAQueryFactory,
) : ReplacementClassPort {

    override fun saveReplacementClassList(replacementClass: List<ReplacementClass>) {
        val replacementClassEntities = replacementClass.map {
            replacementClassMapper.toEntity(
                ReplacementClass(
                    changeMasterId = it.changeMasterId,
                    status = it.status,
                    requestTimetableId = it.requestTimetableId,
                    requestTimetableDate = it.requestTimetableDate,
                    changeTimetableId = it.changeTimetableId,
                    changeTimetableDate = it.changeTimetableDate,
                    teacherId = it.teacherId
                )
            )
        }
        replacementClassRepository.saveAll(replacementClassEntities)
    }

    override fun queryReplacementClassListByUserId(
        userId: Long,
        status: Status?
    ): List<QueryReplacementClassListVO> {
        return queryFactory
            .select(
                QQueryReplacementClassListVO(
                    replacementClassEntity.id,
                    replacementClassEntity.status,
                    userEntity.name,
                    changeMasterEntity.date
                )
            )
            .from(replacementClassEntity)
            .join(replacementClassEntity.changeMasterEntity, changeMasterEntity)
            .join(changeMasterEntity.teacherEntity, teacherEntity)
            .join(teacherEntity.userEntity, userEntity)
            .where(
                replacementClassEntity.teacherEntity.userEntity.id.eq(userId),
                eqStatus(status)
            )
            .fetch()
    }

    override fun queryReplacementClassDetailsById(replacementClassId: Long): QueryReplacementClassDetailsVO? {
        val requestTimetableEntity = QSemesterTimetableEntity("requestTimetableEntity")
        val changeTimetableEntity = QSemesterTimetableEntity("changeTimetableEntity")
        return queryFactory
            .select(
                QQueryReplacementClassDetailsVO(
                    changeMasterEntity.reason,
                    replacementClassEntity.requestTimetableDate,
                    requestTimetableEntity.weekOfDate,
                    requestTimetableEntity.period,
                    requestTimetableEntity.grade,
                    requestTimetableEntity.classNum,
                    requestTimetableEntity.subject,
                    replacementClassEntity.changeTimetableDate,
                    changeTimetableEntity.weekOfDate,
                    changeTimetableEntity.period,
                    changeTimetableEntity.grade,
                    changeTimetableEntity.classNum,
                    changeTimetableEntity.subject
                )
            )
            .from(replacementClassEntity)
            .join(replacementClassEntity.changeMasterEntity, changeMasterEntity)
            .join(replacementClassEntity.requestTimetableEntity, requestTimetableEntity)
            .join(replacementClassEntity.changeTimetableEntity, changeTimetableEntity)
            .where(replacementClassEntity.id.eq(replacementClassId))
            .fetchOne()
    }

    fun eqStatus(status: Status?): BooleanExpression? =
        if (status == null) null else replacementClassEntity.status.eq(status)
}