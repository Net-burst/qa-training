package com.globallogic.qa.training.functional

import com.globallogic.qa.training.functional.model.Response
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.Network
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

import static io.restassured.RestAssured.given

@Testcontainers
class BaseSpec extends Specification {

    @Shared
    Network network = Network.newNetwork()

    @Shared
    GenericContainer qaApplication = new GenericContainer("qa/qa-training").withExposedPorts(8080)

    def "Application should respond successfully on /greeting endpoint"() {
        when: "GET /greeting"
        Response response = given().baseUri("http://${qaApplication.host}:${qaApplication.firstMappedPort}")
                .when()
                .get("/greeting")
                .as(Response.class)

        then: "Response should contain Hello"
        assert response.id
        assert response.greeting.contains("Hello")
        assert !response.quote.isBlank()
    }
}
