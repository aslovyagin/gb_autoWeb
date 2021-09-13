package site.slovyagin.CrmPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BagsList {

    private SelenideElement item = $(By.xpath("//div[@id='products']/div[4]//img[1]"));


    @Step("Клик на элемент")
    public ItemPage clickOnItem() {
        item.click();
        return page(ItemPage.class);
    }
}
