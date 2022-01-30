package com.og.lp.common.config

import com.og.lp.common.exception.NotFoundException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest


@ControllerAdvice
class ExceptionHandlingController() {

	@ExceptionHandler(NotFoundException::class)
	fun handleError(req: HttpServletRequest, ex: NotFoundException): ModelAndView {
		ex.module.screenName
		return ModelAndView("error/404")
			.addObject("exception", ex)
			.addObject("webTitle", "${ex.module.screenName} not found")
	}
}