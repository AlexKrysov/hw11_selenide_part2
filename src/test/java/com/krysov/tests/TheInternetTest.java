package com.krysov.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TheInternetTest extends TestBase {
    @Test
    @Owner("Alex Krysov")
    void dragAndDropTest() {
        step("Открыть страницу Drag and Drop", () ->
                open("https://the-internet.herokuapp.com/drag_and_drop"));
        step("Перетащить элемент А на место элемента В", () ->
                $("#column-a").dragAndDropTo($("#column-b")));
        step("Проверить результат перемещения элементов", () -> {
            $(".column", 1).shouldHave(text("A"));
            $(".column", 0).shouldHave(text("B"));
        });
    }
}
