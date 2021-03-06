package com.og.lp.module.artist.parser


import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.og.lp.module.artist.entity.Artist
import com.og.lp.module.artist.service.ArtistRepository
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException

@Component
class ArtistParser(private val artistRepository: ArtistRepository) {

	private val logger = KotlinLogging.logger {}


	/**
	 * Parse teams from CSV file
	 *
	 * @throws IOException File reading exception
	 */
	fun parse(name: String) {
		try {
			csvReader().readAllWithHeader(File(name)).forEach { row: Map<String, String> ->
				val name = row[Column.ARTIST.column] ?: throw IllegalArgumentException()

				artistRepository.findByName(name) ?: artistRepository.save(
					Artist(
						name = name,
						sort = row[Column.SORT.column].orEmpty()
					)
				)
			}
		} catch (e: Exception) {
			logger.error { "Error while parsing error, error: ${e.message}" }
		}
	}

	enum class Column(val column: String) {
		ARTIST("name"), SORT("alphabet_sort")
	}
}