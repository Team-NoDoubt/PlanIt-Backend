package com.nodoubt.planitbackend.domain.changeMaster.mapper

import com.nodoubt.planitbackend.domain.changeMaster.domain.ChangeMaster
import com.nodoubt.planitbackend.domain.changeMaster.persistence.entity.ChangeMasterEntity
import com.nodoubt.planitbackend.domain.teacher.exception.TeacherNotFoundException
import com.nodoubt.planitbackend.domain.teacher.persistence.TeacherRepository
import com.nodoubt.planitbackend.global.entity.GenericMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ChangeMasterMapper (
    private val teacherRepository: TeacherRepository
) : GenericMapper<ChangeMaster, ChangeMasterEntity> {

    override fun toDomain(entity: ChangeMasterEntity): ChangeMaster = entity.let {
        ChangeMaster(
            id = it.id,
            reason = it.reason,
            status = it.status,
            date = it.date,
            teacherId = it.teacherEntity.id
        )
    }

    override fun toEntity(domain: ChangeMaster): ChangeMasterEntity = domain.let {
        val teacherEntity = teacherRepository.findByIdOrNull(it.teacherId)
            ?: throw TeacherNotFoundException

        ChangeMasterEntity(
            id = it.id,
            reason = it.reason,
            status = it.status,
            date = it.date,
            teacherEntity = teacherEntity
        )
    }
}