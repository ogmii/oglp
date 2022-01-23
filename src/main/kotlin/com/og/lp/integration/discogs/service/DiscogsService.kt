package com.og.lp.integration.discogs.service

import com.og.lp.integration.discogs.dto.DiscogsCollectionResponse
import com.og.lp.integration.discogs.dto.DiscogsResponse
import com.og.lp.integration.discogs.dto.DiscogsRecordResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class DiscogsService(
	@Value("\${discogs.token}") var discogsToken: String,
	@Value("\${discogs.user-name}") var discogsUserName: String,
	@Value("\${discogs.url.base-url}") var baseUrl: String,
	@Value("\${discogs.url.collection-value}") var collectionValueUrl: String,
	@Value("\${discogs.url.record-detail}") var recordDetailUrl: String,
	private val restTemplate: RestTemplate
) {

	fun findRecordById(id: String): DiscogsRecordResponse? {
		return sendGet(
			UriComponentsBuilder.fromHttpUrl(baseUrl)
				.path(recordDetailUrl.replace("%s", id))
				.queryParam("token", discogsToken)
				.toUriString(),
			DiscogsRecordResponse::class.java
		)
	}

	fun getCollectionValue(userName: String): DiscogsCollectionResponse? {
		return sendGet(
			UriComponentsBuilder.fromHttpUrl(baseUrl)
				.path(collectionValueUrl.replace("%s", discogsUserName))
				.queryParam("token", discogsToken)
				.toUriString(),
			DiscogsCollectionResponse::class.java
		)
	}

	private fun <T : DiscogsResponse> sendGet(url: String, response: Class<T>): T? {
		return restTemplate.getForObject(url, response)
	}
}