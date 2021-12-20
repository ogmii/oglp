package com.og.lp.module.artist.parser


import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.og.lp.module.artist.entity.Artist
import com.og.lp.module.artist.mapper.ArtistMapper
import com.og.lp.module.artist.service.ArtistRepository
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException

@Component
class ArtistParser(
	val artistRepository: ArtistRepository,
	val artistMapper: ArtistMapper
) {

	private val logger = KotlinLogging.logger {}


	/**
	 * Parse teams from CSV file
	 *
	 * @throws IOException File reading exception
	 */
	fun parse(name: String) {
		try {
			csvReader().readAll(File(name)).forEach {
				val dto = artistMapper.toArtistCsvDto(it)
				artistRepository.save(
					Artist(
						name = dto.name,
						sort = dto.sort
					)
				)
			}
		} catch (e: Exception) {
			logger.error { "Artist already exist, error: ${e.message}" }
		}
	}
}