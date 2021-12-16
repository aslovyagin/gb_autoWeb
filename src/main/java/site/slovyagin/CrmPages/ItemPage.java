package site.slovyagin.CrmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import site.slovyagin.BaseView;

public class ItemPage extends BaseView {

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(.,'Добавить')]")
    WebElement addItemToBasket;

    public String clickOnAddItemToBasket() {
        String name = driver.findElement(By.xpath("//h1")).getText();
        addItemToBasket.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AddToBasketFrame.addButtonXPath)));
        return name;

    }
}
