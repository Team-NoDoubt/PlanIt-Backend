package com.nodoubt.planitbackend.domain.changeMaster.persistence

import com.nodoubt.planitbackend.domain.changeMaster.domain.ChangeMaster
import com.nodoubt.planitbackend.domain.changeMaster.exception.ChangeMasterNotFoundException
import com.nodoubt.planitbackend.domain.changeMaster.mapper.ChangeMasterMapper
import com.nodoubt.planitbackend.domain.changeMaster.persistence.entity.ChangeMasterEntity
import com.nodoubt.planitbackend.domain.changeMaster.spi.changeMasterSpi.ChangeMasterPort
import com.nodoubt.planitbackend.global.annotation.Adapter
import org.springframework.data.repository.findByIdOrNull

@Adapter
class ChangeMasterPersistenceAdapter(
    private val changeMasterRepository: ChangeMasterRepository,
    private val changeMasterMapper: ChangeMasterMapper
) : ChangeMasterPort {

    override fun saveChangeMaster(changeMaster: ChangeMaster): Long {
        val changeMasterEntity = changeMasterRepository.save(changeMasterMapper.toEntity(changeMaster))
        return changeMasterEntity.id
    }

    override fun queryRequestedTimetableByUserId(teacherId: Long): List<ChangeMaster> {
        val changeMasterEntity = changeMasterRepository.findAllByTeacherEntityIdOrderByDateDesc(teacherId)

        return changeMasterEntity.map {
            changeMasterMapper.toDomain(
                ChangeMasterEntity(
                    id = it.id,
                    reason = it.reason,
                    status = it.status,
                    date = it.date,
                    teacherEntity = it.teacherEntity
                )
            )
        }
    }

    override fun queryChangedMasterDetailsById(changeMasterId: Long): ChangeMaster =
        changeMasterMapper.toDomain(
            changeMasterRepository.findByIdOrNull(changeMasterId)
                ?: throw ChangeMasterNotFoundException
        )

}