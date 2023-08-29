package com.nodoubt.planitbackend.domain.changeMaster.persistence

import com.nodoubt.planitbackend.domain.changeMaster.persistence.entity.ChangeMasterEntity
import org.springframework.data.repository.CrudRepository

interface ChangeMasterRepository : CrudRepository<ChangeMasterEntity, Long> {
}