package com.nodoubt.planitbackend.domain.semesterTimetable.mapper

import com.nodoubt.planitbackend.domain.semesterTimetable.domain.SemesterTimetable
import com.nodoubt.planitbackend.domain.semesterTimetable.persistence.entity.SemesterTimetableEntity
import com.nodoubt.planitbackend.domain.teacher.exception.TeacherNotFoundException
import com.nodoubt.planitbackend.domain.teacher.persistence.TeacherRepository
import com.nodoubt.planitbackend.global.entity.GenericMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class SemesterTimetableMapper(
    private val teacherRepository: TeacherRepository
) : GenericMapper<SemesterTimetable, SemesterTimetableEntity> {

    override fun toDomain(entity: SemesterTimetableEntity): SemesterTimetable = entity.let {
        SemesterTimetable(
            id = it.id,
            year = it.year,
            semester = it.semester,
            grade = it.grade,
            classNum = it.classNum,
            period = it.period,
            weekOfDate = it.weekOfDate,
            subject = it.subject,
            teacherId = it.teacherEntity.id
        )
    }

    override fun toEntity(domain: SemesterTimetable): SemesterTimetableEntity {

        val teacherEntity = teacherRepository.findByIdOrNull(domain.teacherId)
            ?: throw TeacherNotFoundException

        return SemesterTimetableEntity(
            id = domain.id,
            year = domain.year,
            semester = domain.semester,
            grade = domain.grade,
            classNum = domain.classNum,
            period = domain.period,
            weekOfDate = domain.weekOfDate,
            subject = domain.subject,
            teacherEntity = teacherEntity
        )
    }
}