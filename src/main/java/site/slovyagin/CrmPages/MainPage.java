package site.slovyagin.CrmPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public NavigationMenu navigationMenu;

    private static final String mainUrl = "https://uniquefabric.ru/";

    public MainPage() {
        navigationMenu = new NavigationMenu();
    }

    @FindBy(linkText = "FAQ")
    private SelenideElement FAQlink = $(By.linkText("FAQ"));


    public FAQ clickOnFAQlink() {
        FAQlink.click();
        return page(FAQ.class);
    }

    @FindBy(linkText = "Контакты")
    private SelenideElement contactLink = $(By.linkText("Контакты"));

    public Contacts clickOnContactlink() {
        contactLink.click();
        return page(Contacts.class);
    }

    private SelenideElement searchLink = $(By.xpath("//a[@href='/search/']/i"));

    public Search clickOnSearchLink() {
        searchLink.click();
        return page(Search.class);
    }

    @Step("Переход на главную страницу")
    public MainPage getPage() {
        open(mainUrl);
        return this;
    }
}