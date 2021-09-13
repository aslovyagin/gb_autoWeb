package site.slovyagin.CrmPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class ItemPage {


    private SelenideElement addItemToBasket = $(By.xpath("//button[contains(.,'Добавить')]"));
    private SelenideElement itemName = $(By.xpath("//h1"));

    @Step("Добавление в корзину")
    public String clickOnAddItemToBasket() {
        String name = itemName.text();
        addItemToBasket.click();
        return name;

    }
}