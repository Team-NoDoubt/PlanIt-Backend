package com.nodoubt.planitbackend.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.nodoubt.planitbackend.error.ErrorProperty
import com.nodoubt.planitbackend.error.PlanItException
import com.nodoubt.planitbackend.global.error.ErrorCode
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class GlobalExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is PlanItException -> setErrorResponse((e.cause as ErrorProperty), response)
                else ->
                    setErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, response)
            }
        }
    }

    private fun setErrorResponse(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.status = errorProperty.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = StandardCharsets.UTF_8.toString()
        response.writer.write(
            objectMapper.writeValueAsString(errorProperty)
        )
    }
}