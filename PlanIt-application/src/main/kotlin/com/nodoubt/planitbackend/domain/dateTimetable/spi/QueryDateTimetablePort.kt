package com.nodoubt.planitbackend.domain.dateTimetable.spi

import com.nodoubt.planitbackend.domain.dateTimetable.spi.vo.DateTimetableVO
import java.sql.Date

interface QueryDateTimetablePort {

    fun queryDateTimetableList(grade: Int, classNum: Int, monday: Date, friday: Date): List<DateTimetableVO>
}