package com.dailyreport.dailywriter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DailywriterApplication

fun main(args: Array<String>) {
	runApplication<DailywriterApplication>(*args)
}
