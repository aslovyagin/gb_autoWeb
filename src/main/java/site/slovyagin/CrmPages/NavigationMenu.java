package site.slovyagin.CrmPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site.slovyagin.BaseView;

import java.util.List;
import java.util.Locale;

public class NavigationMenu extends BaseView {

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='side-nav__list js-collapse'][1]/li[@class='side-nav__item side-nav__item--parent js-collapse-item']//span[@class='script_disabled_off']")
    List<WebElement> categories;

    @Step("Клик на категорию товара")
    public BagsSubMenu categoryClick(String categoryName) {
        categories.stream().filter(webElement -> webElement.getText().equals(categoryName.toUpperCase(Locale.ROOT))).findFirst().get().click();
        return new BagsSubMenu(driver);
    }
}
