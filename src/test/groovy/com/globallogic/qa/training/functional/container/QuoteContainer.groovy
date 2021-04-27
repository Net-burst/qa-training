package com.globallogic.qa.training.functional.container


import org.testcontainers.containers.MockServerContainer
import org.testcontainers.containers.Network
import org.testcontainers.utility.DockerImageName

class QuoteContainer extends MockServerContainer {

    private static final String IMAGE_NAME = "mockserver/mockserver"
    private static final String VERSION = "mockserver-${System.getProperty("mockserver.version")}"

    QuoteContainer() {
        super(DockerImageName.parse("$IMAGE_NAME:$VERSION"))
    }

    String getInternalUrl() {
        "http://${this.networkAliases.first()}:${this.exposedPorts.first()}"
    }

    @Override
    QuoteContainer withNetwork(Network network) {
        super.withNetwork(network) as QuoteContainer
    }

    @Override
    void close() {
        super.close()
    }
}
