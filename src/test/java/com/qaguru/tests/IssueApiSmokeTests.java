package com.qaguru.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.qaguru.models.Issue;
import com.qaguru.steps.CreatingIssueApiSteps;
import com.qaguru.steps.CreatingIssueWebSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IssueApiSmokeTests {

    private final CreatingIssueApiSteps issueAPI = new CreatingIssueApiSteps();
    private final CreatingIssueWebSteps issueWeb = new CreatingIssueWebSteps();

    private final String TITLE = "Loading all photos from an instagram account";

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @Test
    public void issueAPI() {
        Issue created = issueAPI.createIssue(TITLE);
        issueWeb.openTheSite();
        issueWeb.login();
        issueWeb.openIssue();
        issueWeb.verify(created.getTitle());
    }

}
