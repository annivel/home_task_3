package com.qaguru.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ListenersTests {
    private final String LOGIN = "ririannivel@gmail.com";
    private final String PASSWORD = "ririannivel1"; //TODO fake account's password should be changed to secret password
    private final String TITLE = "Loading all photos from an instagram account";

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    void signInToGit() {
        open("https://github.com/");

        $("a[href='/login']").click();
        $("input[name='login']").sendKeys(LOGIN);
        $("input[name='password']").sendKeys(PASSWORD);
        $("input[name='commit']").click();

        $("span[title='DownloadImages']").click();
        $("span[data-content='Issues']").click();
        $("a[role='button']").click();
        $("#issue_title").sendKeys(TITLE);
        $(".timeline-comment button[type='submit']").click();

        $("form[aria-label='Select assignees']").shouldBe(Condition.visible);
        $(".js-issue-sidebar-form").shouldBe(Condition.visible);
        $(".js-issue-title").shouldHave(Condition.text(TITLE));
    }

}
