package com.og.lp.module.label.data

import com.og.lp.module.label.parser.LabelParser
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.core.Ordered
import org.springframework.stereotype.Component

@Component
class LabelDataLoader(
	private val labelParser: LabelParser
) : Ordered {

	@Value("\${og.lp.label.csv-path}")
	lateinit var csvPath: String

	@EventListener(ContextRefreshedEvent::class)
	fun load() {
		labelParser.parse(csvPath)
	}

	override fun getOrder(): Int {
		return 20
	}
}