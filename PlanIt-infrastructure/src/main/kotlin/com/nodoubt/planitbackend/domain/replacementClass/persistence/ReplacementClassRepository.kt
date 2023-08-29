package com.nodoubt.planitbackend.domain.replacementClass.persistence

import com.nodoubt.planitbackend.domain.replacementClass.persistence.entity.ReplacementClassEntity
import org.springframework.data.repository.CrudRepository

interface ReplacementClassRepository : CrudRepository<ReplacementClassEntity, Long> {
}