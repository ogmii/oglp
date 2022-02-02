package com.og.lp.common.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.time.Duration

@Configuration
class 	AppConfig(
	@Value("\${rest-template.connection-timeout-ms}") var connectionTimeout: Long,
	@Value("\${rest-template.read-timeout-ms}") var readTimeout: Long
) {

	@Bean
	fun restTemplate(builder: RestTemplateBuilder): RestTemplate? {
		return builder
			.setConnectTimeout(Duration.ofMillis(connectionTimeout))
			.setReadTimeout(Duration.ofMillis(readTimeout))
			.build()
	}
}