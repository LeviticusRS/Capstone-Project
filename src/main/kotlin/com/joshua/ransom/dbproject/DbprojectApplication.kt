package com.joshua.ransom.dbproject

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
class DbprojectApplication

fun main(args: Array<String>) {
    runApplication<DbprojectApplication>(*args)
}
