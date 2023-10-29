package com.nodoubt.planitbackend.domain.teacher.spi

import com.nodoubt.planitbackend.domain.teacher.spi.vo.AllTeacherListVO


interface QueryTeacherPort {
    fun queryAllTeacherList(): List<AllTeacherListVO>
}