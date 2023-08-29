package com.nodoubt.planitbackend.domain.reinforecementClass.persistence

import com.nodoubt.planitbackend.domain.reinforecementClass.persistence.entity.ReinforcementClassEntity
import org.springframework.data.repository.CrudRepository

interface ReinforcementClassRepository : CrudRepository<ReinforcementClassEntity, Long> {
}