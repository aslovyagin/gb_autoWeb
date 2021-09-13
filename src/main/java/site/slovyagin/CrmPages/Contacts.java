package site.slovyagin.CrmPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class Contacts {

    public static final String allContanctsXPath = "//div[@class='social social--icon']//li";
    private List<SelenideElement> allContacts = $$(By.xpath("//div[@class='social social--icon']//li"));


    public int getAllContactsSize() {
        return allContacts.size();
    }

}