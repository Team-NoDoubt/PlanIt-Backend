package com.nodoubt.planitbackend.domain.dateTimetable.mapper

import com.nodoubt.planitbackend.domain.dateTimetable.domain.DateTimetable
import com.nodoubt.planitbackend.domain.dateTimetable.persistence.entity.DateTimetableEntity
import com.nodoubt.planitbackend.domain.teacher.persistence.TeacherRepository
import com.nodoubt.planitbackend.global.entity.GenericMapper
import com.nodoubt.planitbackend.global.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class DateTimetableMapper(
    private val teacherRepository: TeacherRepository
) : GenericMapper<DateTimetable, DateTimetableEntity> {

    override fun toDomain(entity: DateTimetableEntity): DateTimetable = entity.let {
        DateTimetable(
            id = it.id,
            year = it.year,
            semester = it.semester,
            date = it.date,
            grade = it.grade,
            classNum = it.classNum,
            period = it.period,
            weekOfDate = it.weekOfDate,
            subject = it.subject,
            isChanged= it.isChanged,
            teacherId = it.teacherEntity.id
        )
    }

    override fun toEntity(domain: DateTimetable): DateTimetableEntity {
        val teacherEntity = teacherRepository.findByIdOrNull(domain.teacherId)
            ?: throw UserNotFoundException

        return DateTimetableEntity(
            id = domain.id,
            year = domain.year,
            semester = domain.semester,
            date = domain.date,
            grade = domain.grade,
            classNum = domain.classNum,
            period = domain.period,
            weekOfDate = domain.weekOfDate,
            subject = domain.subject,
            isChanged = domain.isChanged,
            teacherEntity = teacherEntity
        )
    }
}