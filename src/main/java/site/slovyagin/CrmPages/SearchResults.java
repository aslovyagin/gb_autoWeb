package site.slovyagin.CrmPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site.slovyagin.BaseView;

import java.util.List;

public class SearchResults extends BaseView {

    public SearchResults(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@itemprop]/span[@itemprop]")
    List<WebElement> findedElements;

    public List<WebElement> getFindedElements() {
        return findedElements;
    }
}
