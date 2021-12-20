package com.og.lp.module.artist.data

import com.og.lp.module.artist.parser.ArtistParser
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class ArtistDataLoader(private val artistParser: ArtistParser) {

	@Value("\${og.lp.artist.csv-path}")
	lateinit var csvPath: String


	@EventListener(ContextRefreshedEvent::class)
	fun load() {
		artistParser.parse(csvPath)
	}
}