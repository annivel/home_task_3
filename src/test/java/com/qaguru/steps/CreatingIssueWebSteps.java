package com.qaguru.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreatingIssueWebSteps {
    private final String LOGIN = "annivelichko@gmail.com";
    private final String PASSWORD = "annivelichko20";

    @Step("Open the main page")
    public void openTheSite() {
        open("https://github.com/");
    }

    @Step("Login to GitHub")
    public void login() {
        $("a[href='/login']").click();
        $("input[name='login']").sendKeys(LOGIN);
        $("input[name='password']").sendKeys(PASSWORD);
        $("input[name='commit']").click();
    }

    @Step("Open the issue in the project")
    public void openIssue() {
        $("span[title='DownloadImages']").click();
        $("span[data-content='Issues']").click();
    }

    @Step("Verify the info")
    public void verify(String title) {
        $("a[id^=issue]").click();
        $("form[aria-label='Select assignees']").shouldBe(Condition.visible);
        $(".js-issue-sidebar-form").shouldBe(Condition.visible);
        $(".js-issue-title").shouldHave(Condition.text(title));
    }

}
