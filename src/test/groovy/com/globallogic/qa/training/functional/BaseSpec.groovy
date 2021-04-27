package com.globallogic.qa.training.functional

import com.globallogic.qa.training.functional.container.QaContainer
import com.globallogic.qa.training.functional.container.QuoteContainer
import com.globallogic.qa.training.functional.mock.QuoteMock
import com.globallogic.qa.training.functional.service.QaService
import org.testcontainers.containers.Network
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
abstract class BaseSpec extends Specification {

    @Shared
    Network network = Network.newNetwork()

    @Shared
    QuoteContainer quoteContainer = new QuoteContainer().withNetwork(network)

    @Shared
    QaContainer qaContainer = new QaContainer().withNetwork(network).withQuoteService(quoteContainer.internalUrl)

    @Shared
    QaService qaService

    @Shared
    QuoteMock quoteMock

    def setupSpec() {
        qaService = new QaService(qaContainer)
        quoteMock = new QuoteMock(quoteContainer)
    }
}
