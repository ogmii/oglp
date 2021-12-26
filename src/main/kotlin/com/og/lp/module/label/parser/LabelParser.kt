package com.og.lp.module.label.parser


import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.og.lp.module.label.entity.Label
import com.og.lp.module.label.service.LabelRepository
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException

@Component
class LabelParser(private val labelRepository: LabelRepository) {

	private val logger = KotlinLogging.logger {}


	/**
	 * Parse teams from CSV file
	 *
	 * @throws IOException File reading exception
	 */
	fun parse(name: String) {
		try {
			csvReader().readAllWithHeader(File(name)).forEach { row: Map<String, String> ->
				val label = row[Column.LABEL.column] ?: throw IllegalArgumentException();

				labelRepository.findByName(label) ?: labelRepository.save(
					Label(
						name = label,
						sort = row[Column.SORT.column].orEmpty()
					)
				)
			}
		} catch (e: Exception) {
			logger.error { "Error while parsing labels, error: ${e.message}" }
		}
	}

	enum class Column(val column: String) {
		LABEL("name"), SORT("alphabet_sort")
	}
}