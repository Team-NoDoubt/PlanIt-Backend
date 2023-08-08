package com.nodoubt.planitbackend.global.entity

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseIDEntity (
    id: Long
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = id
}