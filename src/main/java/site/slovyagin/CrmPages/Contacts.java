package site.slovyagin.CrmPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site.slovyagin.BaseView;

import java.util.List;

public class Contacts extends BaseView {

    public static final String allContanctsXPath = "//div[@class='social social--icon']//li";
    @FindBy(xpath = "//div[@class='social social--icon']//li")
    List<WebElement> allContacts;

    public int getAllContactsSize() {
        return allContacts.size();
    }

    public Contacts(WebDriver driver) {
        super(driver);
    }

}
