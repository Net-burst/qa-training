package com.globallogic.qa.training.functional.container

import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.Network
import org.testcontainers.utility.DockerImageName

class QaContainer extends GenericContainer<QaContainer> {

    private static final String IMAGE_NAME = "qa/qa-training"
    private static final int APP_PORT = 8080

    QaContainer() {
        super(DockerImageName.parse(IMAGE_NAME))
        addExposedPort(APP_PORT)
    }

    String getUrl() {
        "http://${this.host}:${this.firstMappedPort}"
    }

    QaContainer withQuoteService(String quoteUrl) {
        withEnv("quoter.url", quoteUrl)
    }

    @Override
    QaContainer withNetwork(Network network) {
        super.withNetwork(network) as QaContainer
    }

    @Override
    void close() {
        super.close()
    }
}
