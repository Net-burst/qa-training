package com.globallogic.qa.qatraining.service

import com.globallogic.qa.qatraining.model.quoter.Quote
import org.springframework.web.client.RestTemplate

class QuoteService {

    private final String url
    private final RestTemplate restTemplate

    QuoteService(String url, RestTemplate restTemplate) {
        this.url = url
        this.restTemplate = restTemplate
    }

    String getQuote() {
        getRandomQuote()?.value?.quote ?: "Oops"
    }

    private Quote getRandomQuote() {
        restTemplate.getForObject(url, Quote.class)
    }
}
