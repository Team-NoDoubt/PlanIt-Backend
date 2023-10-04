package com.nodoubt.planitbackend.domain.semesterTimetable.persistence

import com.nodoubt.planitbackend.domain.semesterTimetable.persistence.entity.SemesterTimetableEntity
import org.springframework.data.repository.CrudRepository

interface SemesterTimetableRepository : CrudRepository<SemesterTimetableEntity, Long>