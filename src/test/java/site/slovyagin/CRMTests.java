package site.slovyagin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CRMTests {
    static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://crm.geekbrains.space/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        loginToCrm();
    }

    @Test
    @DisplayName("Проверка создания контакта")
    void createCrmContant() {
        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Контрагенты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//*[text()=\"Контактные лица\"]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Создать контактное лицо\"]")));
        driver.findElement(By.xpath("//*[text()=\"Создать контактное лицо\"]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'crm_contact_lastName')]")));
        driver.findElement(By.xpath("//input[contains(@id,'crm_contact_lastName')]")).sendKeys("name1111");
        driver.findElement(By.xpath("//input[contains(@id,'crm_contact_firstName')]")).sendKeys("name3333");
        driver.findElement(By.xpath("//input[contains(@id,'crm_contact_jobTitle')]")).sendKeys("manager");

        driver.findElement(By.xpath("//span[@class=\"select2-chosen\"]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(.//div[@class=\"select2-result-label\"])[2]")));
        driver.findElement(By.xpath("(.//div[@class=\"select2-result-label\"])[2]")).click();

        driver.findElement(By.xpath("//button[contains(@class,\"main-group\")][contains(.,'Сохранить')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо сохранено']")));
        assertTrue(driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']")).isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("/view"));
    }

    @Test
    @DisplayName("Проверка создания проекта")
    void createCrmProject() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_index']/a")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("crm_project[name]1");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("test");

        Select businessUnitSelect = new Select(driver.findElement(By.xpath("//select[contains(@id,'crm_project_businessUnit')]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(driver.findElement(By.xpath("//select[contains(@id,'crm_project_curator')]")));
        curatorSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select rpSelect = new Select(driver.findElement(By.xpath("//select[contains(@id,'crm_project_rp')]")));
        rpSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select managerSelect = new Select(driver.findElement(By.xpath("//select[contains(@id,'crm_project_manager')]")));
        managerSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationVars = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        organizationVars.get(0).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-container select2']")));
        driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select2-drop']//input")));
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1111");
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning-uid')]")));
        driver.findElement(By.xpath("//body")).sendKeys("testtest");

        Thread.sleep(5000);

        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//button[contains(@class,\"main-group\")][contains(.,'Сохранить')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));
        assertTrue(driver.findElement(By.xpath("//*[text()='Проект сохранен']")).isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("/view"));
    }

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
