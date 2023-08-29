package com.nodoubt.planitbackend.domain.reinforecementClass.mapper

import com.nodoubt.planitbackend.domain.changeMaster.exception.ChangeMasterNotFoundException
import com.nodoubt.planitbackend.domain.changeMaster.persistence.ChangeMasterRepository
import com.nodoubt.planitbackend.domain.dateTimetable.exception.DateTimetableNotFoundException
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.DateTimetableRepository
import com.nodoubt.planitbackend.domain.reinforcementClass.domain.ReinforcementClass
import com.nodoubt.planitbackend.domain.reinforecementClass.persistence.entity.ReinforcementClassEntity
import com.nodoubt.planitbackend.domain.teacher.exception.TeacherNotFoundException
import com.nodoubt.planitbackend.domain.teacher.persistence.TeacherRepository
import com.nodoubt.planitbackend.global.entity.GenericMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ReinforcementClassMapper (
    private val changeMasterRepository: ChangeMasterRepository,
    private val dateTimetableRepository: DateTimetableRepository,
    private val teacherRepository: TeacherRepository
) : GenericMapper<ReinforcementClass, ReinforcementClassEntity> {

    override fun toDomain(entity: ReinforcementClassEntity): ReinforcementClass = entity.let{
        ReinforcementClass(
            id = it.id,
            changeMasterId = it.changeMasterEntity.id,
            status = it.status,
            reasonRejected = it.reasonRejected,
            dateTimetableId = it.dateTimetableEntity.id,
            teacherId = it.teacherEntity.id
        )
    }

    override fun toEntity(domain: ReinforcementClass): ReinforcementClassEntity {

        val changeMasterEntity = changeMasterRepository.findByIdOrNull(domain.changeMasterId)
            ?: throw ChangeMasterNotFoundException

        val dateTimetableEntity = dateTimetableRepository.findByIdOrNull(domain.dateTimetableId)
            ?: throw DateTimetableNotFoundException

        val teacherEntity = teacherRepository.findByIdOrNull(domain.teacherId)
            ?: throw TeacherNotFoundException

        return ReinforcementClassEntity(
            id = domain.id,
            changeMasterEntity = changeMasterEntity,
            status = domain.status,
            reasonRejected = domain.reasonRejected,
            dateTimetableEntity = dateTimetableEntity,
            teacherEntity = teacherEntity
        )
    }
}