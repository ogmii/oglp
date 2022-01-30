package com.og.lp.integration.discogs.dto.response

class DiscogsImageResponse(
	val height: Long,
	val width: Long,
	val type: Type,
	val resource_url: String,
	val uri: String,
)

enum class Type {
	primary, secondary
}
