package com.nodoubt.planitbackend.domain.changeMaster.domain

import java.time.LocalDate

class ChangeMaster (
    val id: Long = 0,
    val reason: String,
    val confirmed: Confirmed,
    val date: LocalDate,
    val teacherId: Long
)