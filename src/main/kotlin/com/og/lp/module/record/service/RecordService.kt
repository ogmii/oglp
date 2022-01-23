package com.og.lp.module.record.service

import com.og.lp.integration.discogs.service.DiscogsService
import com.og.lp.module.record.entity.Record
import org.springframework.stereotype.Service


@Service
class RecordService(private val recordRepository: RecordRepository, private val discogsService: DiscogsService) {

	fun findById(id: Long): Record {
		val record = recordRepository.find(id) ?: throw IllegalArgumentException()

		if (!record.hasCover() && record.discogsId != null) {
			discogsService.findRecordById(record.discogsId)?.let { recordRepository.save(record.withCovers(it)) }
		}

		return record
	}

}
