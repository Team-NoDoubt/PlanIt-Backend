package com.nodoubt.planitbackend.domain.changeMaster.usecase

import com.nodoubt.planitbackend.annotation.UseCase
import com.nodoubt.planitbackend.domain.changeMaster.api.ChangeTimetablePort
import com.nodoubt.planitbackend.domain.changeMaster.api.dto.request.ChangeTimetableRequest
import com.nodoubt.planitbackend.domain.changeMaster.domain.ChangeMaster
import com.nodoubt.planitbackend.domain.changeMaster.spi.CommandChangeMasterPort
import com.nodoubt.planitbackend.domain.reinforcementClass.domain.ReinforcementClass
import com.nodoubt.planitbackend.domain.changeMaster.domain.Status
import com.nodoubt.planitbackend.domain.reinforcementClass.spi.CommandReinforcementPort
import com.nodoubt.planitbackend.domain.replacementClass.domain.ReplacementClass
import com.nodoubt.planitbackend.domain.replacementClass.spi.CommandReplacementPort
import com.nodoubt.planitbackend.domain.user.spi.UserSecurityPort
import java.time.LocalDate

@UseCase
open class ChangeTimetableUseCase(
    private val userSecurityPort: UserSecurityPort,
    private val commandChangeMasterPort: CommandChangeMasterPort,
    private val commandReinforcementPort: CommandReinforcementPort,
    private val commandReplacementPort: CommandReplacementPort
) : ChangeTimetablePort {
    override fun execute(request: ChangeTimetableRequest) {
        val date = LocalDate.now()
        val user = userSecurityPort.getCurrentUser()

        val masterId = commandChangeMasterPort.saveChangeMaster(
            ChangeMaster(
                reason = request.reason,
                status = Status.REQUESTING,
                date = date,
                teacherId = user.id
            )
        )

        commandReinforcementPort.saveReinforcementClassList(
            request.reinforcementList.map {
                ReinforcementClass(
                    changeMasterId = masterId,
                    status = Status.REQUESTING,
                    reinforcementPlan = it.reinforcementPlan,
                    dateTimetableId = it.reinforcementClassId,
                    teacherId = it.reinforcementTeacherId
                )
            }
        )

        commandReplacementPort.saveReplacementClassList(
            request.replacementList.map {
                ReplacementClass(
                    changeMasterId = masterId,
                    status = Status.REQUESTING,
                    requestTimetableId = it.requestTimetableId,
                    changeTimetableId = it.changeTimetableId,
                    teacherId = it.replacementTeacherId
                )
            }
        )
        println(4)
    }
}