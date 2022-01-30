package com.og.lp.module.record.service

import com.og.lp.integration.discogs.service.DiscogsService
import com.og.lp.module.record.entity.Record
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class RecordService(private val recordRepository: RecordRepository, private val discogsService: DiscogsService) {

	fun findById(id: Long): Record {
		val record = recordRepository.findByIdOrNull(id) ?: throw IllegalArgumentException()

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

		return record
	}

}
