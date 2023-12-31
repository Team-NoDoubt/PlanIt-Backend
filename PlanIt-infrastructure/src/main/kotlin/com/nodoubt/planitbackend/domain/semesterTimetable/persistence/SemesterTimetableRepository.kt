package com.nodoubt.planitbackend.domain.semesterTimetable.persistence

import com.nodoubt.planitbackend.domain.semesterTimetable.persistence.entity.SemesterTimetableEntity
import org.springframework.data.repository.CrudRepository

interface SemesterTimetableRepository : CrudRepository<SemesterTimetableEntity, Long> {
    fun findByWeekOfDateAndGradeAndClassNumAndPeriod(weekOfDate: Int, grade: Int, classNum: Int, period: Int): SemesterTimetableEntity?
}