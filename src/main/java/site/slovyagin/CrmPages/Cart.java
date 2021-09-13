package site.slovyagin.CrmPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Cart {
    public SelenideElement titleOfItemXpath = $(By.xpath("//span[@class='cart-list__item-title']/a"));
}
