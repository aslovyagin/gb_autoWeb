package site.slovyagin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AddingItemInBasket {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        driver.get("https://uniquefabric.ru/");

        driver.findElement(By.
                xpath("//noscript[text()='<a href=\"/catalog/sumki_i_ryukzaki/\">Сумки и Рюкзаки</a>']/preceding-sibling::span")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Сумки")));
        driver.findElement(By.linkText("Сумки")).click();

        driver.findElement(By.xpath("//div[@id='products']/div[4]//img[1]")).click();

        driver.findElement(By.xpath("//button[contains(.,'Добавить')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"cart-widget\"]//a")));
        driver.findElement(By.xpath("//div[@class=\"cart-widget\"]//a")).click();

        driver.quit();
    }
}