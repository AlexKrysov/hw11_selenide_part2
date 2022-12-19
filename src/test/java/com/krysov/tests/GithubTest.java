package com.krysov.tests;

import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GithubTest extends TestBase {
    @Test
    @Owner("Alex Krysov")
    void githubTest() {
        step("Открыть страницу Github", () ->
                open("https://github.com/"));
        step("Навести курсор на Solutions и кликнуть на Enterprise", () -> {
            $(new ByText("Solutions")).hover();
            $(linkText("Enterprise")).click();
        });
        step("проверить наличие текста (Build like the best) на странице Enterprise", () ->
                $(".application-main ").shouldHave(text("Build like the best")));
    }
}
