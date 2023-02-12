package github;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class TestBase {
    protected final static String URL = "https://github.com/";
    protected final String ALLURE_REPO = "qa-guru/allure-notifications";
    protected final SelenideElement mainPageSearch = $x(".//input[@name='q']");
    protected final SelenideElement issuesTab = $("#issues-tab");

    protected final String ISSUE_NAME = "Live version for Allure TestOps";

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1980x1080";
        Configuration.headless = true;
        //Configuration.holdBrowserOpen = true;

    }
}