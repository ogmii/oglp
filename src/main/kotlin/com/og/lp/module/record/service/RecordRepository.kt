package com.og.lp.module.record.service

import com.og.lp.module.record.entity.Record
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull

interface RecordRepository : CrudRepository<Record, Long> {

	fun findByTitleAndCatalogNumber(title: String?, catalogNumber: String?): Record?
	
}