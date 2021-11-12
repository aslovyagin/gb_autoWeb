package site.slovyagin.CrmPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class BagsSubMenu {

    private List<SelenideElement> bagsSubMenus = $$(By.xpath("//li[@class='side-nav__item side-nav__item--parent js-collapse-item opened']//span[@class='side-nav__link-sub']/a[contains(@href,'sumki_i_ryukzaki')]"));

    @Step("Выбор подкатегории")
    public void clickBagsSubMenu(String subCategory) {
        bagsSubMenus.stream().filter(webElement -> webElement.getText()
                .contains(subCategory)).findFirst().get().click();
    }
}