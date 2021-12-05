package site.slovyagin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopTests {
    static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://uniquefabric.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    void addItemInBasket() {
        driver.findElement(By.
                xpath("//noscript[contains(.,'sumki_i_ryukzaki')]/preceding-sibling::span")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Сумки")));
        driver.findElement(By.linkText("Сумки")).click();

        driver.findElement(By.xpath("//div[@id='products']/div[4]//img[1]")).click();
        String itemName = driver.findElement(By.xpath("//h1")).getText();
        driver.findElement(By.xpath("//button[contains(.,'Добавить')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"cart-widget\"]//a")));
        driver.findElement(By.xpath("//div[@class=\"cart-widget\"]//a")).click();

        assertTrue(itemName.contains(driver.findElement(By.xpath("//span[@class=\"cart-list__item-title\"]/a")).getText()));
    }

    @Test
    @DisplayName("Переход по ссылке FAQ")
    void checkFaqLink() {
        driver.findElement(By.linkText("FAQ")).click();
        assertTrue(driver.getCurrentUrl().equals("https://uniquefabric.ru/help/faq/"));
        assertTrue(driver.getTitle().contains("FAQ"));
    }

    @Test
    @DisplayName("Проверка наличия всех социальных сетей в контактах")
    void checkSocialMedias() {
        driver.findElement(By.linkText("Контакты")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"social social--icon\"]//li")));
        assertTrue(new ArrayList<WebElement>(driver.findElements(By.xpath("//div[@class='social social--icon']//li"))).size() == 3);
    }

    @Test
    @DisplayName("Поиск выдает релевантные значения")
    void checkSearchInput() {
        String itemForSearch = "Платье";
        driver.findElement(By.xpath("//a[@href='/search/']/i")).click();
        driver.findElement(By.xpath("//input[contains(@class,'search__input')]")).sendKeys(itemForSearch);
        driver.findElement(By.xpath("//button/i[contains(@class,\"icon-search\")]")).click();

        List<WebElement> items = new ArrayList<>(driver.findElements(By.xpath("//a[@itemprop]/span[@itemprop]")));

        assertTrue(items.stream().allMatch(s -> s.getText().contains(itemForSearch)));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

