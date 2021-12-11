package com.og.lp.module.record.service

import org.springframework.stereotype.Service

@Service
class RecordService(private val recordRepository: RecordRepository) {
	fun findById(id: Long): Any {
		TODO("Not yet implemented")
	}

}
