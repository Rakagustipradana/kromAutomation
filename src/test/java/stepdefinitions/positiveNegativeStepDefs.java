package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class positiveNegativeStepDefs extends commonSetup {

    @Given("^User have a access login to saucelab with correct data$")
    public void userHaveAAccessLoginToSaucelabWithCorrectData() throws Throwable {
        positiveNegativePage.captureScreen();
        positiveNegativePage.loginToWeb(this.GetProperties("Username"),this.GetProperties("Password"));
        positiveNegativePage.captureScreen();
    }

    @Then("^User do logout$")
    public void userDoLogout() {
        positiveNegativePage.captureScreen();
        positiveNegativePage.logoutFromWeb();
        positiveNegativePage.captureScreen();
    }

    @When("^User choose item product$")
    public void userChooseItemProduct() {
        positiveNegativePage.verifyProductItem();
        positiveNegativePage.chooseItemProduct();
        positiveNegativePage.captureScreen();
    }

    @Given("^User do login with incorrect (.*) and (.*)$")
    public void userDoLoginWithIncorrectUsernameAndPassword(String invalidUsername, String invalidPassword) {
        positiveNegativePage.captureScreen();
        positiveNegativePage.loginFailedToWeb(invalidUsername, invalidPassword);
        positiveNegativePage.captureScreen();
    }

    @Then("^User verify error message (.*)$")
    public void userVerifyErrorMessage(String type) {
        positiveNegativePage.verifyErrorMessageLogin(type);
        positiveNegativePage.captureScreen();
    }

    @And("^User verify shopping cart badge$")
    public void userVerifyShoppingCartBadge() {
        positiveNegativePage.captureScreen();
        positiveNegativePage.verifyCartBadge();
    }

    @And("^User click on cart button$")
    public void userClickOnCartButton() {
        positiveNegativePage.clickOnButtonCart();
        positiveNegativePage.captureScreen();
    }

    @And("^User verify cart page$")
    public void userVerifyCartPage() {
        positiveNegativePage.verifyCartPage();
        positiveNegativePage.captureScreen();
    }

    @And("^User do removed item product$")
    public void userDoRemovedItemProduct() {
        positiveNegativePage.captureScreen();
        positiveNegativePage.clickOnButtonRemoveItemProduct();
        positiveNegativePage.captureScreen();
    }

    @When("^User choose item product by name$")
    public void userChooseItemProductByName() {
        positiveNegativePage.captureScreen();
        positiveNegativePage.chooseItemProductByName();
        positiveNegativePage.captureScreen();
    }

    @Then("^User verify item product details$")
    public void userVerifyItemProductDetails() {
        positiveNegativePage.verifyItemProductDetails();
        positiveNegativePage.captureScreen();
    }

    @And("^User verify product page$")
    public void userVerifyProductPage() {
        positiveNegativePage.verifyProductPage();
        positiveNegativePage.captureScreen();
    }

    @Then("^User do filter by price low to high$")
    public void userDoFilterByPriceLowToHigh() {
        positiveNegativePage.captureScreen();
        positiveNegativePage.selectPriceLowToHigh();
        positiveNegativePage.captureScreen();
    }
}
