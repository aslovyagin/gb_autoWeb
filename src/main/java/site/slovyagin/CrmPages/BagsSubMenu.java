package site.slovyagin.CrmPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site.slovyagin.BaseView;

import java.util.List;
import java.util.Locale;

public class BagsSubMenu extends BaseView {

    public BagsSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='side-nav__item side-nav__item--parent js-collapse-item opened']//span[@class='side-nav__link-sub']/a[contains(@href,'sumki_i_ryukzaki')]")
    List<WebElement> bagsSubMenus;

    public BagsList clickBagsSubMenu(String subCategory) {
        bagsSubMenus.stream().filter(webElement -> webElement.getText()
                .equals(subCategory)).findFirst().get().click();
        return new BagsList(driver);
    }

}
