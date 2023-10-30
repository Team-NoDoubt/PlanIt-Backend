package com.nodoubt.planitbackend.domain.teacher.persistence

import com.nodoubt.planitbackend.domain.teacher.persistence.entity.QTeacherEntity.teacherEntity
import com.nodoubt.planitbackend.domain.teacher.persistence.vo.QQueryAllTeacherListVO
import com.nodoubt.planitbackend.domain.teacher.spi.TeacherPort
import com.nodoubt.planitbackend.domain.teacher.spi.vo.AllTeacherListVO
import com.nodoubt.planitbackend.global.annotation.Adapter
import com.querydsl.jpa.impl.JPAQueryFactory

@Adapter
class TeacherPersistenceAdapter(
    private val jpaQueryFactory: JPAQueryFactory
) : TeacherPort {

    override fun queryAllTeacherList(): List<AllTeacherListVO> =
        jpaQueryFactory
            .select(
                QQueryAllTeacherListVO(
                    teacherEntity.id,
                    teacherEntity.userEntity.name
                )
            )
            .from(teacherEntity)
            .orderBy(teacherEntity.id.asc())
            .fetch()

}