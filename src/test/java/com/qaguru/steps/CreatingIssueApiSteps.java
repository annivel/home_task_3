package com.qaguru.steps;

import com.qaguru.models.Issue;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class CreatingIssueApiSteps {

    @Step("Create an issue by API call")
    public Issue createIssue(String title) {
        final Issue toCreate = new Issue() {{
            setTitle(title);
        }};

        return given()
                .header("Authorization", "token 94cc14b6577a1a82af3a18c677dbe36d240677ad")
                .baseUri("https://api.github.com/")
                .body(toCreate)
                .when()
                .post("/repos/annivel/DownloadImages/issues")
                .then()
                .statusCode(201)
                .extract()
                .as(Issue.class);
    }

}
