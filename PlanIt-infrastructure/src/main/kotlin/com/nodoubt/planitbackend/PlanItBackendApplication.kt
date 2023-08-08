package com.nodoubt.planitbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class PlanItBackendApplication

fun main(args: Array<String>) {
    runApplication<PlanItBackendApplication>(*args)
}
