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
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepsTest extends TestBase {

    @Test
    @Feature("Check issue with lambda steps")
    @Story("Verify issue name via lambda steps")
    @Owner("RuslanG")
    @DisplayName("Verify issue name isssue with lambda steps")
    public void lambdaStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open(URL);
        });
        step("Find repository " + ALLURE_REPO, () -> {
            mainPageSearch.click();
            mainPageSearch.sendKeys(ALLURE_REPO);
            mainPageSearch.pressEnter();
        });
        step("Click repo link " + ALLURE_REPO, () -> {
            $(linkText(ALLURE_REPO)).click();
        });
        step("Open tab issue " + issuesTab, () -> {
            $(issuesTab).click();
        });
        step("Verify issue name " + ISSUE_NAME, () -> {
            $(withText(ISSUE_NAME)).should(Condition.exist);
        });
    }


}