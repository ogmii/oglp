package com.og.lp.module.record.parser


import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.og.lp.module.artist.entity.Artist
import com.og.lp.module.artist.service.ArtistRepository
import com.og.lp.module.label.entity.Label
import com.og.lp.module.label.service.LabelRepository
import com.og.lp.module.record.entity.Format
import com.og.lp.module.record.entity.Record
import com.og.lp.module.record.service.FormatRepository
import com.og.lp.module.record.service.RecordRepository
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException
import java.time.Instant

@Component
class RecordParser(
	private val recordRepository: RecordRepository,
	private val formatRepository: FormatRepository,
	private val artistRepository: ArtistRepository,
	private val labelRepository: LabelRepository
) {

	private val logger = KotlinLogging.logger {}


	/**
	 * Parse teams from CSV file
	 *
	 * @throws IOException File reading exception
	 */
	fun parse(name: String) {
		try {
			csvReader().readAllWithHeader(File(name)).forEach { row: Map<String, String> ->
				recordRepository.findByTitleAndCatalogNumber(
					row[Column.TITLE.column],
					row[Column.CATALOG_NUMBER.column]
				) ?: recordRepository.save(
					Record(
						title = row[Column.TITLE.column].orEmpty(),
						artist = getArtist(row[Column.ARTIST.column]),
						releaseYear = row[Column.RELEASE_YEAR.column]?.toLong(),
						catalogNumber = row[Column.CATALOG_NUMBER.column],
						format = getFormat(row[Column.FORMAT.column]),
						variant = row[Column.VARIANT.column],
						comment = row[Column.COMMENT.column],
						coverFront = row[Column.COVER_FRONT.column]?.takeIf { it.isNotEmpty() },
						coverBack = row[Column.COVER_BACK.column]?.takeIf { it.isNotEmpty() },
						discogsId = row[Column.DISCOGS_ID.column]?.takeIf { it.isNotEmpty() },
						sort = row[Column.SORT.column] ?: throw IllegalArgumentException(),
						owned = row[Column.OWNED.column]?.toBoolean() ?: throw IllegalArgumentException(),
						label = getLabel(row[Column.LABEL.column]),
						created = Instant.now()
					)
				)
			}
		} catch (e: Exception) {
			logger.error { "Error while parsing records, error: ${e.message}" }
		}
	}

	private fun getArtist(name: String?): Artist {
		if (name == null) {
			throw IllegalArgumentException("Artist name is null")
		}

		return artistRepository.findByName(name) ?: throw IllegalArgumentException("Artist $name not found")
	}

	private fun getLabel(name: String?): Label {
		if (name == null) {
			throw IllegalArgumentException("Label name is null")
		}

		return labelRepository.findByName(name) ?: throw IllegalArgumentException("Label $name not found")
	}

	private fun getFormat(name: String?): Format {
		if (name == null) {
			throw IllegalArgumentException("Format name is null")
		}

		val format = formatRepository.findByFormat(name)

		return format ?: formatRepository.save(Format(format = name))
	}

	enum class Column(val column: String) {
		TITLE("name"),
		ARTIST("artist"),
		RELEASE_YEAR("release_year"),
		CATALOG_NUMBER("catalog_number"),
		FORMAT("format"),
		VARIANT("variant"),
		COMMENT("comment"),
		COVER_FRONT("cover_front"),
		COVER_BACK("cover_back"),
		DISCOGS_ID("discogs_release_id"),
		SORT("alphabet_sort"),
		OWNED("owned"),
		LABEL("label")
	}
}