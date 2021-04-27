package com.globallogic.qa.training.functional.service

import com.globallogic.qa.training.functional.container.QaContainer
import com.globallogic.qa.training.functional.model.Greeting
import io.restassured.RestAssured
import io.restassured.response.Response

class QaService {
    private static final String GREETING_ENDPOINT = "/greeting"
    private final String url

    QaService(QaContainer qaApplication) {
        this.url = qaApplication.url
    }

    Greeting getGreeting() {
        Response response = RestAssured.given().baseUri(url)
                .when()
                .get(GREETING_ENDPOINT)

        if (response.statusCode != 200) {
            throw new ApiException(response.body().asString())
        }

        response.as(Greeting)
    }

    Greeting getGreeting(String name) {
        Response response = RestAssured.given().baseUri(url)
                .when()
                .queryParam("name", name)
                .get(GREETING_ENDPOINT)

        if (response.statusCode != 200) {
            throw new ApiException(response.body().asString())
        }

        response.as(Greeting)
    }
}
