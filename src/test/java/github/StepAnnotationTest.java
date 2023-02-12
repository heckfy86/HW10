package github;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepAnnotationTest extends TestBase {

    @Step("Open main page")
    public void openMainPage() {
        open(URL);
    }

    @Step("Find repository")
    public void findRepository() {
        mainPageSearch.click();
        mainPageSearch.sendKeys(ALLURE_REPO);
        mainPageSearch.pressEnter();
    }

    @Step("Click repo link")
    public void clickRepoLink() {
        $(linkText(ALLURE_REPO)).click();
    }

    @Step("Open Tab issue")
    public void openIssueTab() {
        $(issuesTab).click();
    }

    @Step("Verify issue name")
    public void verifyIssueName() {
        $(withText(ISSUE_NAME)).should(Condition.exist);
    }
}