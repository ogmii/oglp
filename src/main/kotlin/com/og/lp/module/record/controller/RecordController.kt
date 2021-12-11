package com.og.lp.module.record.controller

import com.og.lp.module.record.service.RecordResponseService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RecordController(private val recordResponseService: RecordResponseService) {

	@GetMapping("/")
	fun index(model: Model): String {
		recordResponseService.getIndex(model)
		return "index"
	}

	@GetMapping("/{id}")
	fun index(model: Model, id: Long): String {
		recordResponseService.getRecord(model, id)
		return "record/detail"
	}
}