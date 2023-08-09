package com.nodoubt.planitbackend.domain.teacher.persistence

import com.nodoubt.planitbackend.domain.teacher.persistence.entity.TeacherEntity
import org.springframework.data.repository.CrudRepository

interface TeacherRepository : CrudRepository<TeacherEntity, Long> {
}