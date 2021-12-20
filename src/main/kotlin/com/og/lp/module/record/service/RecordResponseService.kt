package com.og.lp.module.record.service

import org.springframework.stereotype.Service
import org.springframework.ui.Model
import org.springframework.ui.set

@Service
class RecordResponseService(private val recordService : RecordService) {

	fun getIndex(model: Model) {
		model["title"] = "OG LP"
	}

	fun getRecord(model: Model, id: Long) {
		val record = recordService.findById(id)
//		model["title"] = record.getTitle()
		model["record"] = record
	}

}