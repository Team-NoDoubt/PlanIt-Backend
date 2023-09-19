package com.nodoubt.planitbackend.domain.replacementClass.persistence

import com.nodoubt.planitbackend.domain.replacementClass.domain.ReplacementClass
import com.nodoubt.planitbackend.domain.replacementClass.mapper.ReplacementClassMapper
import com.nodoubt.planitbackend.domain.replacementClass.spi.ReplacementClassPort
import com.nodoubt.planitbackend.global.annotation.Adapter

@Adapter
class ReplacementClassAdapter (
    private val replacementClassRepository: ReplacementClassRepository,
    private val replacementClassMapper: ReplacementClassMapper
) : ReplacementClassPort {

    override fun saveReplacementClassList(replacementClass: List<ReplacementClass>) {
        val replacementClassEntities = replacementClass.map {
            replacementClassMapper.toEntity(
                ReplacementClass(
                    changeMasterId = it.changeMasterId,
                    status = it.status,
                    requestTimetableId = it.requestTimetableId,
                    changeTimetableId = it.changeTimetableId,
                    teacherId = it.teacherId
                )
            )
        }
        replacementClassRepository.saveAll(replacementClassEntities)
    }
}