package com.nodoubt.planitbackend.domain.reinforecementClass.persistence

import com.nodoubt.planitbackend.domain.changeMaster.domain.ReinforcementClass
import com.nodoubt.planitbackend.domain.changeMaster.spi.reinforcementClassSpi.ReinforcementClassPort
import com.nodoubt.planitbackend.domain.changeMaster.spi.reinforcementClassSpi.vo.RequestedReinforcementClassDetailsVO
import com.nodoubt.planitbackend.domain.reinforecementClass.mapper.ReinforcementClassMapper
import com.nodoubt.planitbackend.domain.reinforecementClass.persistence.entity.QReinforcementClassEntity.reinforcementClassEntity
import com.nodoubt.planitbackend.domain.reinforecementClass.persistence.vo.QQueryRequestedReinforcementClassDetailsVO
import com.nodoubt.planitbackend.domain.semesterTimetable.persistence.entity.QSemesterTimetableEntity.semesterTimetableEntity
import com.nodoubt.planitbackend.domain.teacher.persistence.entity.QTeacherEntity.teacherEntity
import com.nodoubt.planitbackend.global.annotation.Adapter
import com.querydsl.jpa.impl.JPAQueryFactory

@Adapter
class ReinforcementClassAdapter(
    private val queryFactory: JPAQueryFactory,
    private val reinforcementClassRepository: ReinforcementClassRepository,
    private val reinforcementClassMapper: ReinforcementClassMapper
) : ReinforcementClassPort {

    override fun saveReinforcementClassList(reinforcementClass: List<ReinforcementClass>) {
        val reinforcementClassEntities = reinforcementClass.map {
            reinforcementClassMapper.toEntity(
                ReinforcementClass(
                    changeMasterId = it.changeMasterId,
                    status = it.status,
                    reinforcementPlan = it.reinforcementPlan,
                    reasonRejected = it.reasonRejected,
                    semesterTimetableId = it.semesterTimetableId,
                    timetableDate = it.timetableDate,
                    teacherId = it.teacherId
                )
            )
        }
        reinforcementClassRepository.saveAll(reinforcementClassEntities)
    }

    override fun queryReinforcementClassByChangeMasterId(changeMasterId: Long): List<RequestedReinforcementClassDetailsVO> =
        queryFactory
            .select(
                QQueryRequestedReinforcementClassDetailsVO(
                    reinforcementClassEntity.timetableDate,
                    semesterTimetableEntity.period,
                    semesterTimetableEntity.grade,
                    semesterTimetableEntity.classNum,
                    semesterTimetableEntity.subject,
                    reinforcementClassEntity.reinforcementPlan,
                    teacherEntity.userEntity.name,
                    reinforcementClassEntity.status,
                    reinforcementClassEntity.reasonRejected
                )
            )
            .from(reinforcementClassEntity)
            .innerJoin(reinforcementClassEntity.semesterTimetableEntity, semesterTimetableEntity)
            .on(reinforcementClassEntity.semesterTimetableEntity.id.eq(semesterTimetableEntity.id))
            .innerJoin(reinforcementClassEntity.teacherEntity, teacherEntity)
            .on(reinforcementClassEntity.teacherEntity.id.eq(teacherEntity.id))
            .where(reinforcementClassEntity.changeMasterEntity.id.eq(changeMasterId))
            .fetch()

}