package site.slovyagin.CrmPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class AddToBasketFrame {

    public static final String addButtonXPath = "//div[@class='cart-widget']//a";

    private SelenideElement addButton = $(By.xpath(addButtonXPath));

    public void clickOnAddButton() {
        addButton.click();
    }
}
