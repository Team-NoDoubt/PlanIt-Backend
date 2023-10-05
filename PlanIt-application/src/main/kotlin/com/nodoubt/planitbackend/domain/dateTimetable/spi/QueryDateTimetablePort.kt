package com.nodoubt.planitbackend.domain.dateTimetable.spi

import com.nodoubt.planitbackend.domain.dateTimetable.spi.vo.ChangedTimetableVO
import com.nodoubt.planitbackend.domain.dateTimetable.spi.vo.DateTimetableVO
import java.time.LocalDate

interface QueryDateTimetablePort {

    fun queryDateTimetableList(grade: Int, classNum: Int, monday: LocalDate, friday: LocalDate): List<DateTimetableVO>

    fun queryChangedTimetableList(grade: Int, classNum: Int, monday: LocalDate, friday: LocalDate): List<ChangedTimetableVO>
}