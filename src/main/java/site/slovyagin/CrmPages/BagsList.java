package site.slovyagin.CrmPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site.slovyagin.BaseView;

public class BagsList extends BaseView {

    public BagsList(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='products']/div[4]//img[1]")
    WebElement item;

    public ItemPage clickOnItem() {
        item.click();
        return new ItemPage(driver);
    }
}
