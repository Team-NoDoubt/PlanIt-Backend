package com.nodoubt.planitbackend.domain.teacher.mapper

import com.nodoubt.planitbackend.domain.teacher.domain.Teacher
import com.nodoubt.planitbackend.domain.teacher.persistence.entity.TeacherEntity
import com.nodoubt.planitbackend.domain.user.persistence.UserRepository
import com.nodoubt.planitbackend.global.entity.GenericMapper
import com.nodoubt.planitbackend.global.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class TeacherMapper(
    private val userRepository: UserRepository
) : GenericMapper<Teacher, TeacherEntity> {

    override fun toDomain(entity: TeacherEntity): Teacher = entity.let {
        Teacher(
            id = it.id,
            userId = it.userEntity.id
        )
    }

    override fun toEntity(domain: Teacher): TeacherEntity {

        val userEntity = userRepository.findByIdOrNull(domain.userId)
            ?: throw UserNotFoundException

        return TeacherEntity(
            id = domain.id,
            userEntity = userEntity
        )
    }
}