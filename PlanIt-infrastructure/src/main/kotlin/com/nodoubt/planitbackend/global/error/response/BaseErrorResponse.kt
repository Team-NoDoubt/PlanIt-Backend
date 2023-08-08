package com.nodoubt.planitbackend.global.error.response

import com.nodoubt.planitbackend.error.PlanItException

class BaseErrorResponse (
    val status: Int,
    val message: String
) {

    companion object {

        fun of(e: PlanItException): BaseErrorResponse {
            return BaseErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }
}