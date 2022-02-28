package com.og.lp.module.record.controller

import com.og.lp.module.record.service.RecordResponseService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class RecordController(private val recordResponseService: RecordResponseService) {

	@GetMapping("/")
	fun index(model: Model): String {
		recordResponseService.getIndex(model)
		return "index"
	}

	@GetMapping("/collection")
	fun collection(model: Model): String {
		recordResponseService.getCollection(model)
		return "collection"
	}

	@GetMapping("/record/{id}")
	fun detail(
		@PathVariable id: Long,
		model: Model
	): String {
		recordResponseService.findById(model, id)
		return "detail"
	}
}