package github;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideListenerTest extends TestBase {

    @Test
    @Feature("Check issue with pure Selenide")
    @Story("Verify issue name via steps annotation with pure Selenide")
    @Owner("RuslanG")
    @DisplayName("Verify issue name isssue with Selenide")
    public void checkPage() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(URL);

        mainPageSearch.click();
        mainPageSearch.sendKeys(ALLURE_REPO);
        mainPageSearch.pressEnter();

        $(linkText(ALLURE_REPO)).click();
        $(issuesTab).click();
        $(withText(ISSUE_NAME)).should(Condition.exist);
    }


    @Test
    @Feature("Check issue")
    @Story("Verify issue name via steps annotation")
    @Owner("RuslanG")
    @DisplayName("Verify issue name isssue with @Step annotation")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepAnnotationTest steps = new StepAnnotationTest();

        steps.openMainPage();
        steps.findRepository();
        steps.clickRepoLink();
        steps.openIssueTab();
        steps.verifyIssueName();
    }
}