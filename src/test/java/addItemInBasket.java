import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import site.slovyagin.CrmPages.*;

import static com.codeborne.selenide.Selenide.screenshot;

public class addItemInBasket {

    public String itemName;

    @Given("^I am at main page$")
    public void iAmAtMainPage() {
        new MainPage().getPage();
    }

    @When("^I choose category in navigation menu$")
    public void iChooseCategoryInNavigationMenu() throws InterruptedException {
        new MainPage().navigationMenu.categoryClick("Сумки и рюкзаки");
        Thread.sleep(10000);
        new BagsSubMenu().clickBagsSubMenu("Сумки");

    }

    @And("^I click on item$")
    public void iClickOnItem() {
        new BagsList().clickOnItem();
    }

    @And("^I add item to basket$")
    public void iAddItemToBasket() throws InterruptedException {
        itemName = new ItemPage().clickOnAddItemToBasket();
    }

    @And("^I confirm adding item to basket$")
    public void iConfirmAddingItemToBasket() {
        new AddToBasketFrame().clickOnAddButton();
    }

    @Then("^Items in basket contains choosen item$")
    public void itemsInBasketContainsChoosenItem() {
        Assertions.assertTrue("test".contains(new Cart().titleOfItemXpath.text()));
    }
}
