package com.nodoubt.planitbackend.domain.changeMaster.persistence

import com.nodoubt.planitbackend.domain.changeMaster.domain.ChangeMaster
import com.nodoubt.planitbackend.domain.changeMaster.mapper.ChangeMasterMapper
import com.nodoubt.planitbackend.global.annotation.Adapter

@Adapter
class ChangeMasterPersistenceAdapter (
    private val changeMasterRepository: ChangeMasterRepository,
    private val changeMasterMapper: ChangeMasterMapper
) : ChangeMasterPort {

    override fun saveChangeMaster(changeMaster: ChangeMaster): Long {
        val changeMasterEntity = changeMasterRepository.save(changeMasterMapper.toEntity(changeMaster))
        return changeMasterEntity.id
    }

}