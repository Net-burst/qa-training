package com.globallogic.qa.qatraining.configuration

import com.globallogic.qa.qatraining.service.QuoteService
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class ApplicationConfiguration {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build()
    }

    @Bean
    QuoteService quoteService(@Value('${quoter.url}') String quoterUrl, RestTemplate restTemplate) {
        return new QuoteService(quoterUrl, restTemplate)
    }
}
