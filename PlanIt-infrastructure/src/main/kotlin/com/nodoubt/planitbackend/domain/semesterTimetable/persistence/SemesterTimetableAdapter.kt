package com.nodoubt.planitbackend.domain.semesterTimetable.persistence

import com.nodoubt.planitbackend.domain.semesterTimetable.domain.SemesterTimetable
import com.nodoubt.planitbackend.domain.semesterTimetable.exception.SemesterTimetableNotFoundException
import com.nodoubt.planitbackend.domain.semesterTimetable.mapper.SemesterTimetableMapper
import com.nodoubt.planitbackend.domain.semesterTimetable.spi.SemesterTimetablePort
import com.nodoubt.planitbackend.global.annotation.Adapter

@Adapter
class SemesterTimetableAdapter(
    private val semesterTimetableRepository: SemesterTimetableRepository,
    private val semesterTimetableMapper: SemesterTimetableMapper
) : SemesterTimetablePort {

    override fun querySemesterTimetableIdByWeekOfDateAndPeriodAndGradeAndClassNum(weekOfDate: Int, grade: Int, classNum: Int, period: Int): SemesterTimetable =
        semesterTimetableMapper.toDomain(
            semesterTimetableRepository.findByWeekOfDateAndGradeAndClassNumAndPeriod(weekOfDate, grade, classNum, period)
                ?: throw SemesterTimetableNotFoundException
        )
}