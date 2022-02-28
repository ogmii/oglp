package com.og.lp.module.record.service

import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.ui.Model
import org.springframework.ui.set

@Service
class RecordResponseService(
	private val recordService: RecordService
) {

	fun getIndex(model: Model) {
		model["webTitle"] = "OG LP"
		model["hottestRecords"] = recordService.findHottestRecords().map { record -> record.toRecordView() }
	}

	fun findById(model: Model, id: Long) {
		val record = recordService.findById(id)

		model["webTitle"] = record.getWebTitle()
		model["record"] = record.toRecordView()
	}

	fun getCollection(model: Model) {
		model["data"] = recordService.getCollection()
		model["webTitle"] = "Collection value"
	}

}