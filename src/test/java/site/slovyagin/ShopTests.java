package site.slovyagin;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import site.slovyagin.CrmPages.AddToBasketFrame;
import site.slovyagin.CrmPages.Cart;
import site.slovyagin.CrmPages.FAQ;
import site.slovyagin.CrmPages.MainPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Story("Тестирование основного функционала магазина")
@Owner("Aleksey Slovyagin")
public class ShopTests extends BaseTest {

    @Test
    @DisplayName("Добавление товара в корзину")
    @Description("Добавление товара в корзину")
    @Severity(value = SeverityLevel.BLOCKER)
    void addItemInBasket() throws InterruptedException {
        String itemName = new MainPage(driver)
                .getPage()
                .navigationMenu
                .categoryClick("Сумки и рюкзаки")
                .clickBagsSubMenu("Сумки")
                .clickOnItem()
                .clickOnAddItemToBasket();

        new AddToBasketFrame(driver).clickOnAddButton();

        assertTrue(itemName.contains(driver.findElement(By.xpath(Cart.titleOfItemXpath)).getText()));

    }

    @Test
    @DisplayName("Переход по ссылке FAQ")
    @Description("Переход по ссылке FAQ")
    @Severity(value = SeverityLevel.MINOR)
    void checkFaqLink() {
        new MainPage(driver)
                .getPage()
                .clickOnFAQlink();

        assertTrue(driver.getCurrentUrl().equals(FAQ.currentUrl));
        assertTrue(driver.getTitle().contains("FAQ"));
    }

    @Test
    @DisplayName("Проверка наличия всех социальных сетей в контактах")
    @Description("Проверка наличия всех социальных сетей в контактах")
    @Severity(value = SeverityLevel.MINOR)
    void checkSocialMedias() {
        int numberOfContacts = new MainPage(driver)
                .getPage()
                .clickOnContactlink().getAllContactsSize();

        assertTrue(numberOfContacts == 3);
    }

    @Test
    @DisplayName("Поиск выдает релевантные значения")
    @Description("Поиск выдает релевантные значения")
    @Severity(value = SeverityLevel.NORMAL)
    void checkSearchInput() {

        List<WebElement> findedElements = new MainPage(driver)
                .getPage()
                .clickOnSearchLink()
                .typeSearchInput("Платье")
                .clickOnSearchButton()
                .getFindedElements();

        assertTrue(findedElements.stream().allMatch(s -> s.getText().contains("Платье")));
    }

}