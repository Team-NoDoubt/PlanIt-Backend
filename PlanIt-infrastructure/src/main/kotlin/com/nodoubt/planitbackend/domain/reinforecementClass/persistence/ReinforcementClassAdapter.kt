package com.nodoubt.planitbackend.domain.reinforecementClass.persistence

import com.nodoubt.planitbackend.domain.changeMaster.domain.ReinforcementClass
import com.nodoubt.planitbackend.domain.changeMaster.spi.reinforcementClassSpi.ReinforcementClassPort
import com.nodoubt.planitbackend.domain.reinforecementClass.mapper.ReinforcementClassMapper
import com.nodoubt.planitbackend.global.annotation.Adapter

@Adapter
class ReinforcementClassAdapter (
    private val reinforcementClassRepository: ReinforcementClassRepository,
    private val reinforcementClassMapper: ReinforcementClassMapper
) : ReinforcementClassPort {

    override fun saveReinforcementClassList(reinforcementClass: List<ReinforcementClass>) {
        val reinforcementClassEntities = reinforcementClass.map {
            reinforcementClassMapper.toEntity(
                ReinforcementClass(
                    changeMasterId = it.changeMasterId,
                    status = it.status,
                    reinforcementPlan = it.reinforcementPlan,
                    reasonRejected = it.reasonRejected,
                    semesterTimetableId = it.semesterTimetableId,
                    timetableDate = it.timetableDate,
                    teacherId = it.teacherId
                )
            )
        }
        reinforcementClassRepository.saveAll(reinforcementClassEntities)
    }
}