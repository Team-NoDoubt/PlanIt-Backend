package com.nodoubt.planitbackend.domain.replacementClass.mapper

import com.nodoubt.planitbackend.domain.changeMaster.exception.ChangeMasterNotFoundException
import com.nodoubt.planitbackend.domain.changeMaster.persistence.ChangeMasterRepository
import com.nodoubt.planitbackend.domain.dateTimetable.exception.DateTimetableNotFoundException
import com.nodoubt.planitbackend.domain.changeMaster.domain.ReplacementClass
import com.nodoubt.planitbackend.domain.replacementClass.persistence.entity.ReplacementClassEntity
import com.nodoubt.planitbackend.domain.semesterTimetable.persistence.SemesterTimetableRepository
import com.nodoubt.planitbackend.domain.teacher.exception.TeacherNotFoundException
import com.nodoubt.planitbackend.domain.teacher.persistence.TeacherRepository
import com.nodoubt.planitbackend.global.entity.GenericMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ReplacementClassMapper  (
    private val changeMasterRepository: ChangeMasterRepository,
    private val semesterTimetableRepository: SemesterTimetableRepository,
    private val teacherRepository: TeacherRepository
) : GenericMapper<ReplacementClass, ReplacementClassEntity> {

    override fun toDomain(entity: ReplacementClassEntity): ReplacementClass = entity.let{
        ReplacementClass(
            id = it.id,
            changeMasterId = it.changeMasterEntity.id,
            status = it.status,
            reasonRejected = it.reasonRejected,
            requestTimetableId = it.requestTimetableEntity.id,
            requestTimetableDate = it.requestTimetableDate,
            changeTimetableDate = it.changeTimetableDate,
            changeTimetableId = it.requestTimetableEntity.id,
            teacherId = it.teacherEntity.id
        )
    }

    override fun toEntity(domain: ReplacementClass): ReplacementClassEntity {

        val changeMasterEntity = changeMasterRepository.findByIdOrNull(domain.changeMasterId)
            ?: throw ChangeMasterNotFoundException

        val requestTimetableEntity = semesterTimetableRepository.findByIdOrNull(domain.requestTimetableId)
            ?: throw DateTimetableNotFoundException

        val changeTimetableEntity = semesterTimetableRepository.findByIdOrNull(domain.changeTimetableId)
            ?: throw DateTimetableNotFoundException

        val teacherEntity = teacherRepository.findByIdOrNull(domain.teacherId)
            ?: throw TeacherNotFoundException

        return ReplacementClassEntity(
            id = domain.id,
            changeMasterEntity = changeMasterEntity,
            status = domain.status,
            reasonRejected = domain.reasonRejected,
            requestTimetableEntity = requestTimetableEntity,
            requestTimetableDate = domain.requestTimetableDate,
            changeTimetableEntity = changeTimetableEntity,
            changeTimetableDate = domain.changeTimetableDate,
            teacherEntity = teacherEntity
        )
    }
}