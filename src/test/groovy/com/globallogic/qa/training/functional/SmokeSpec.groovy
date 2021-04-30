package com.globallogic.qa.training.functional

import com.globallogic.qa.training.functional.model.Greeting
import com.globallogic.qa.training.functional.model.Quote

class SmokeSpec extends BaseSpec {

    def "Application should respond successfully on /greeting endpoint"() {
        given: "Quote"
        def quoteString = "asd"
        def quote = Quote.getDefaultQuote(quoteString)

        and: "Quote response"
        quoteMock.setQuote(quote)

        when: "GET /greeting"
        Greeting response = qaService.getGreeting()

        then: "Response should contain Hello"
        assert response.id
        assert response.greeting.contains("Hello")
        assert response.quote == quoteString
    }

    def "Application should append the name to a greeting when name is passed in the query string"() {
        given: "Quote"
        def quoteString = "asd"
        def quote = Quote.getDefaultQuote(quoteString)

        and: "Quote response"
        quoteMock.setQuote(quote)

        and: "Name"
        def name = "dsa"

        when: "GET /greeting"
        Greeting response = qaService.getGreeting(name)

        then: "Response should contain Hello"
        assert false
    }
}
