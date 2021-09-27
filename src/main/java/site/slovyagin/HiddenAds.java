package site.slovyagin;

/**
 * Hello world!
 *
 */
public class HiddenAds
{
    public static void scenarioWithExtention() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=src/main/resources/chrome_profile");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://afisha.ru");
        Thread.sleep(10000);
    }

    public static void runJsScriptExample() throws InterruptedException {
        driver.get("https://afisha.ru");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("function getElementByXpath(path) {\n" +
                "  return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\n" +
                "}\n" +
                "\n" +
                "getElementByXpath(\"//div[@data-test='HONEY-AD AD-ad_1']\").remove();");
        Thread.sleep(10000);
    }}