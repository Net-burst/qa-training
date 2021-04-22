package com.globallogic.qa.qatraining.controller

import com.globallogic.qa.qatraining.model.Greeting
import com.globallogic.qa.qatraining.service.QuoteService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    QuoteService quoteService

    GreetingController(QuoteService quoteService) {
        this.quoteService = quoteService
    }

    private final AtomicLong counter = new AtomicLong()

    @GetMapping("/greeting")
    Greeting getGreeting(@RequestParam(value = "name", defaultValue = "Anonymous") String name) {
        return new Greeting(id: counter.incrementAndGet(), greeting: "Hello, $name", quote: quoteService.getQuote())
    }
}
