package site.slovyagin.CrmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import site.slovyagin.BaseView;

public class MainPage extends BaseView {
    public NavigationMenu navigationMenu;

    private static final String mainUrl = "https://uniquefabric.ru/";

    public MainPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }

    @FindBy(linkText = "FAQ")
    WebElement FAQlink;

    public FAQ clickOnFAQlink() {
        FAQlink.click();
        return new FAQ(driver);
    }

    @FindBy(linkText = "Контакты")
    WebElement contactLink;

    public Contacts clickOnContactlink() {
        contactLink.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Contacts.allContanctsXPath)));
        return new Contacts(driver);
    }

    @FindBy(xpath = "//a[@href='/search/']/i")
    WebElement searchLink;

    public Search clickOnSearchLink() {
        searchLink.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Search.searchInputXPath)));
        return new Search(driver);
    }

    public MainPage getPage() {
        driver.get(mainUrl);
        return this;
    }


}
