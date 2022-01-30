package com.og.lp.integration.discogs.dto.response

class DiscogsRecordResponse(
	private val id: Long,
	private val artists_sort: String,
	private val title: String,
	private val released: String,
	private val notes: String?,
	private val images: List<DiscogsImageResponse>
) : DiscogsResponse() {
	fun getFrontCover(): DiscogsImageResponse? {
		return images.firstOrNull { it.type == Type.primary }
	}

	fun getBackCover(): DiscogsImageResponse? {
		return images.firstOrNull { it.type == Type.secondary }
	}
}