package com.og.lp.module.record.service

import com.og.lp.common.exception.Module
import com.og.lp.common.exception.NotFoundException
import com.og.lp.integration.discogs.service.DiscogsService
import com.og.lp.module.record.entity.Record
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class RecordService(private val recordRepository: RecordRepository, private val discogsService: DiscogsService) {

	fun findById(id: Long): Record {
		val record = recordRepository.findByIdOrNull(id) ?: throw NotFoundException(Module.RECORD, id)

		updateCover(record)

		return record
	}

	fun findHottestRecords(): List<Record> {
		val records = recordRepository.findHottestRecords()

		records.filter { r -> !r.hasCover() && r.discogsId != null }
			.map { updateCover(it) }

		return records
	}

	fun updateCover(record: Record) {
		if (!record.hasCover() && record.discogsId != null) {
			discogsService.findRecordById(record.discogsId)?.let {
				recordRepository.save(
					record.withCovers(
						it.getFrontCover()?.uri,
						it.getBackCover()?.uri
					)
				)
			}
		}
	}

}
