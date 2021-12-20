package com.og.lp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class OgLpApplication

fun main(args: Array<String>) {
	runApplication<OgLpApplication>(*args)
}