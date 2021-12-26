package com.og.lp.module.record.data

import com.og.lp.module.record.parser.RecordParser
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.core.Ordered
import org.springframework.stereotype.Component

@Component
class RecordDataLoader(
	private val recordParser: RecordParser
) : Ordered {

	@Value("\${og.lp.record.csv-path}")
	lateinit var csvPath: String

	@EventListener(ContextRefreshedEvent::class)
	fun load() {
		recordParser.parse(csvPath)
	}

	override fun getOrder(): Int {
		return 30
	}
}