package com.og.lp.module.record.service

import com.og.lp.module.record.entity.Record
import org.springframework.data.repository.CrudRepository

interface RecordRepository : CrudRepository<Record, Long> {

	fun find(id: Long): Record?

	fun findByTitleAndCatalogNumber(title: String?, catalogNumber: String?): Record?
}