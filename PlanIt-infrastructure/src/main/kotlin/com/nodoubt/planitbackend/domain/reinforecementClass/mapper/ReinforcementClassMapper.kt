package com.nodoubt.planitbackend.domain.reinforecementClass.mapper

import com.nodoubt.planitbackend.domain.changeMaster.exception.ChangeMasterNotFoundException
import com.nodoubt.planitbackend.domain.changeMaster.persistence.ChangeMasterRepository
import com.nodoubt.planitbackend.domain.changeMaster.domain.ReinforcementClass
import com.nodoubt.planitbackend.domain.reinforecementClass.persistence.entity.ReinforcementClassEntity
import com.nodoubt.planitbackend.domain.semesterTimetable.exception.SemesterTimetableNotFoundException
import com.nodoubt.planitbackend.domain.semesterTimetable.persistence.SemesterTimetableRepository
import com.nodoubt.planitbackend.domain.teacher.exception.TeacherNotFoundException
import com.nodoubt.planitbackend.domain.teacher.persistence.TeacherRepository
import com.nodoubt.planitbackend.global.entity.GenericMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ReinforcementClassMapper(
    private val changeMasterRepository: ChangeMasterRepository,
    private val semesterTimetableRepository: SemesterTimetableRepository,
    private val teacherRepository: TeacherRepository
) : GenericMapper<ReinforcementClass, ReinforcementClassEntity> {

    override fun toDomain(entity: ReinforcementClassEntity): ReinforcementClass = entity.let {
        ReinforcementClass(
            id = it.id,
            changeMasterId = it.changeMasterEntity.id,
            status = it.status,
            reinforcementPlan = it.reinforcementPlan,
            reasonRejected = it.reasonRejected,
            semesterTimetableId = it.semesterTimetableEntity.id,
            timetableDate = it.timetableDate,
            teacherId = it.teacherEntity.id
        )
    }

    override fun toEntity(domain: ReinforcementClass): ReinforcementClassEntity {

        val changeMasterEntity = changeMasterRepository.findByIdOrNull(domain.changeMasterId)
            ?: throw ChangeMasterNotFoundException

        val semesterTimetableEntity = semesterTimetableRepository.findByIdOrNull(domain.semesterTimetableId)
            ?: throw SemesterTimetableNotFoundException

        val teacherEntity = teacherRepository.findByIdOrNull(domain.teacherId)
            ?: throw TeacherNotFoundException

        return ReinforcementClassEntity(
            id = domain.id,
            changeMasterEntity = changeMasterEntity,
            status = domain.status,
            reinforcementPlan = domain.reinforcementPlan,
            reasonRejected = domain.reasonRejected,
            semesterTimetableEntity = semesterTimetableEntity,
            timetableDate = domain.timetableDate,
            teacherEntity = teacherEntity
        )
    }
}