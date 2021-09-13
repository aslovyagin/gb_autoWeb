package site.slovyagin.CrmPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class Search {


    private SelenideElement searchInput = $(By.xpath("searchInputXPath"));

    public Search typeSearchInput(String forSearch) {
        searchInput.sendKeys(forSearch);
        return this;
    }

    private SelenideElement searchButton = $(By.xpath("//button/i[contains(@class,'icon-search')]"));

    public SearchResults clickOnSearchButton() {
        searchButton.click();
        return page(SearchResults.class);
    }
}