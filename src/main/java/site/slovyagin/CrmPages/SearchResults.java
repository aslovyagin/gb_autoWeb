package site.slovyagin.CrmPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

import java.util.List;

public class SearchResults  {

    private List<SelenideElement> findedElements = $$(By.xpath("//a[@itemprop]/span[@itemprop]"));

    public List<SelenideElement> getFindedElements() {
        return findedElements;
    }
}
