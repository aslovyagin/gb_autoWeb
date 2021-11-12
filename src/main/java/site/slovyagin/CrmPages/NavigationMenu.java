package site.slovyagin.CrmPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class NavigationMenu {

    private List<SelenideElement> categories = $$(By.xpath("//ul[@class='side-nav__list js-collapse'][1]/li[@class='side-nav__item side-nav__item--parent js-collapse-item']//span[@class='script_disabled_off']"));

    @Step("Выбор категории")
    public BagsSubMenu categoryClick(String categoryName) {
        categories.stream().filter(webElement -> webElement.getText().equals(categoryName.toUpperCase(Locale.ROOT))).findFirst().get().click();
        return page(BagsSubMenu.class);
    }
}
