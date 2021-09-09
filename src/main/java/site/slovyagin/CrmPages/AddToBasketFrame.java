package site.slovyagin.CrmPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import site.slovyagin.BaseView;

public class AddToBasketFrame extends BaseView {
    public AddToBasketFrame(WebDriver driver) {
        super(driver);
    }

    public static final String addButtonXPath = "//div[@class='cart-widget']//a";

    @FindBy(xpath = addButtonXPath)
    WebElement addButton;

    @Step("Клик на кнопку добавить в корзину")
    public void clickOnAddButton() {
        addButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Cart.titleOfItemXpath)));
    }
}
