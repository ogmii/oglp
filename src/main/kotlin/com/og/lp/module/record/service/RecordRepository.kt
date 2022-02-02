package com.og.lp.module.record.service

import com.og.lp.module.record.entity.Record
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface RecordRepository : CrudRepository<Record, Long> {

	fun findByTitleAndCatalogNumber(title: String?, catalogNumber: String?): Record?

	@Query(nativeQuery = true, value = "select * from record order by RANDOM() limit 3")
	fun findHottestRecords(): List<Record>

}