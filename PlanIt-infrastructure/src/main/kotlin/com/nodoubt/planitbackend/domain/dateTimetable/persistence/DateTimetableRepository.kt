package com.nodoubt.planitbackend.domain.dateTimetable.persistence

import com.nodoubt.planitbackend.domain.dateTimetable.persistence.entity.DateTimetableEntity
import org.springframework.data.repository.CrudRepository

interface DateTimetableRepository : CrudRepository<DateTimetableEntity, Long>