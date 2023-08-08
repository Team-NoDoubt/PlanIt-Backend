package com.nodoubt.planitbackend.error

open class PlanItException(
    val errorProperty: ErrorProperty
) : RuntimeException() {

    val status: Int
        get() = errorProperty.status

    override val message: String
        get() = errorProperty.message
}