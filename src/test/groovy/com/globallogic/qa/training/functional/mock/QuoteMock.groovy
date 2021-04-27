package com.globallogic.qa.training.functional.mock

import com.fasterxml.jackson.databind.ObjectMapper
import com.globallogic.qa.training.functional.container.QuoteContainer
import com.globallogic.qa.training.functional.model.Quote
import org.mockserver.client.MockServerClient
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse

import static org.mockserver.model.MediaType.APPLICATION_JSON
import static org.springframework.http.HttpMethod.GET

class QuoteMock {

    private static final ObjectMapper mapper = new ObjectMapper()
    private static final String PATH = "/"
    private final MockServerClient client

    QuoteMock(QuoteContainer quoteApplication) {
        this.client = new MockServerClient(quoteApplication.host, quoteApplication.firstMappedPort)
    }

    void setQuote(Quote quote) {
        String string = mapper.writeValueAsString(quote)

        client.when(
                HttpRequest.request()
                        .withMethod(GET.name())
                        .withPath(PATH)
        ).respond(
                HttpResponse.response()
                        .withContentType(APPLICATION_JSON)
                        .withBody(string)
        )
    }

    void reset() {
        client.reset()
    }
}
