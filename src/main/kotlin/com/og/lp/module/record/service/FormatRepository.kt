package com.og.lp.module.record.service

import com.og.lp.module.record.entity.Format
import org.springframework.data.repository.CrudRepository

interface FormatRepository : CrudRepository<Format, Long> {
	fun findByFormat(format: String): Format?
}