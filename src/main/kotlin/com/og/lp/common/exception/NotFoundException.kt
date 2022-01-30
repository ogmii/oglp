package com.og.lp.common.exception

class NotFoundException(
	val module: Module,
	val id: Long
) : Exception()