package site.slovyagin.CrmPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site.slovyagin.BaseView;

public class Search extends BaseView {

    public Search(WebDriver driver) {
        super(driver);
    }

    public static final String searchInputXPath = "//input[contains(@class,'search__input')]";
    @FindBy(xpath = searchInputXPath)
    WebElement searchInput;

    @Step("Ввод поискового запроса")
    public Search typeSearchInput(String forSearch) {
        searchInput.sendKeys(forSearch);
        return this;
    }

    @FindBy(xpath = "//button/i[contains(@class,'icon-search')]")
    WebElement searchButton;

    @Step("Клик на кнопку 'Найти'")
    public SearchResults clickOnSearchButton() {
        searchButton.click();
        return new SearchResults(driver);
    }
}