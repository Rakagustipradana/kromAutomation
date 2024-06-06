package page.object;

import com.microsoft.playwright.options.SelectOption;
import junit.framework.TestCase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class positiveNegativePage extends basePage {

    String inputUsername = "//*[@id='user-name']";

    String inputPassword = "//*[@id='password']";

    String loginButton = "//*[@id='login-button']";

    String burgerButton = "//button[contains(.,'Open Menu')]";

    String logoutButton = "//a[contains(@data-test,'logout-sidebar-link')]";

    String errorMessageFailedLogin = "//h3[@data-test='error'][contains(.,'Epic sadface: Username and password do not match any user in this service')]";

    String errorMessageFailedLoginText = "Epic sadface: Username and password do not match any user in this service";

    String errorMessageNullLogin = "//h3[@data-test='error'][contains(.,'Epic sadface: Username is required')]";

    String errorMessageNullLoginText = "Epic sadface: Username is required";

    String errorMessageLogoutUser = "//h3[@data-test='error'][contains(.,'Epic sadface: Sorry, this user has been locked out.')]";

    String getErrorMessageLogoutUserText = "Epic sadface: Sorry, this user has been locked out.";

    String imageProductItem = "//img[contains(@alt,'Sauce Labs Backpack')]";

    String titleProduct = "//div[@class='inventory_item_name '][contains(.,'Sauce Labs Backpack')]";

    String addButtonCartSauceLabBackpack = "//button[contains(@data-test,'add-to-cart-sauce-labs-backpack')]";

    String cartBadge = "//span[@class='shopping_cart_badge'][contains(.,'1')]";

    String cartButton = "//a[@class='shopping_cart_link'][contains(.,'1')]";

    String QTYLabel = "//div[@class='cart_quantity_label']";

    String QTYLabelText = "QTY";

    String descriptionLabel = "//div[@class='cart_desc_label']";

    String descriptionLabelText = "Description";

    String sauceLabBackpackItemOnCart = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]";

    String sauceLabBackpackItemOnCartText = "Sauce Labs Backpack";

    String itemProductDesc = "//div[@class='inventory_item_desc'][contains(.,'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.')]";

    String itemProductDescText = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

    String removeItemButton = "//button[@class='btn btn_secondary btn_small cart_button'][contains(.,'Remove')]";

    String itemProductByName = "//div[@class='inventory_item_name '][contains(.,'Sauce Labs Backpack')]";

    String imageItemProductDetails = "//img[contains(@alt,'Sauce Labs Backpack')]";

    String titleItemProductDetails = "//div[@class='inventory_details_name large_size'][contains(.,'Sauce Labs Backpack')]";

    String titleItemProductDetailsText = "Sauce Labs Backpack";

    String descriptionItemProductDetails = "//div[@class='inventory_details_desc large_size'][contains(.,'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.')]";

    String descriptionItemProductDetailsText = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

    String priceItemProductDetails = "//div[@class='inventory_details_price'][contains(.,'$29.99')]";

    String cartButtonOnDetails = "//button[@class='btn btn_primary btn_small btn_inventory'][contains(.,'Add to cart')]";

    String titleProductPage = "//span[@class='title'][contains(.,'Products')]";

    String titleProductPageText = "Products";

    String filterButton = "//select[contains(@class,'product_sort_container')]";

    public void loginToWeb(String username, String password) {
        try {
            sendKeys(inputUsername, username);
            sendKeys(inputPassword, password);
            clickOnButton(loginButton);
            driver.waitForTimeout(5000);
        } catch (Exception e) {
            TestCase.fail(e.getMessage());
        }
    }

    public void logoutFromWeb() {
        driver.waitForTimeout(5000);
        clickOnButton(burgerButton);
        clickOnButton(logoutButton);
    }

    public void chooseItemProduct() {
        clickOnButton(addButtonCartSauceLabBackpack);
    }

    public void loginFailedToWeb(String invalidUsername, String invalidPassword) {
        try {
            sendKeys(inputUsername, invalidUsername);
            sendKeys(inputPassword, invalidPassword);
            clickOnButton(loginButton);
        } catch (Exception e) {
            TestCase.fail(e.getMessage());
        }
    }

    public void verifyErrorMessageLogin(String type) {
        switch (type) {
            case " ": //try to input null
                assertThat(driver.locator(errorMessageNullLogin)).hasText(errorMessageNullLoginText);
                break;
            case "random":
                assertThat(driver.locator(errorMessageFailedLogin)).hasText(errorMessageFailedLoginText);
                break;
            case "normal":
                assertThat(driver.locator(errorMessageLogoutUser)).hasText(getErrorMessageLogoutUserText);
                break;
            case "specialCharacter":
                assertThat(driver.locator(errorMessageFailedLogin)).hasText(errorMessageFailedLoginText);
                break;
            default:
                break;
        }
    }

    public void verifyProductItem() {
        driver.waitForTimeout(3000);
        assertThat(driver.locator(imageProductItem)).isVisible();
        assertThat(driver.locator(titleProduct)).isVisible();
    }

    public void verifyCartBadge() {
        driver.waitForTimeout(3000);
        assertThat(driver.locator(cartBadge)).isVisible();
    }

    public void clickOnButtonCart() {
        clickOnButton(cartButton);
    }

    public void verifyCartPage() {
        assertThat(driver.locator(QTYLabel)).hasText(QTYLabelText);
        assertThat(driver.locator(descriptionLabel)).hasText(descriptionLabelText);
        assertThat(driver.locator(sauceLabBackpackItemOnCart)).hasText(sauceLabBackpackItemOnCartText);
        assertThat(driver.locator(itemProductDesc)).hasText(itemProductDescText);
    }

    public void clickOnButtonRemoveItemProduct() {
        clickOnButton(removeItemButton);
    }

    public void chooseItemProductByName() {
        clickOnButton(itemProductByName);
    }

    public void verifyItemProductDetails() {
        assertThat(driver.locator(imageItemProductDetails)).isVisible();
        assertThat(driver.locator(titleItemProductDetails)).hasText(titleItemProductDetailsText);
        assertThat(driver.locator(descriptionItemProductDetails)).hasText(descriptionItemProductDetailsText);
        assertThat(driver.locator(priceItemProductDetails)).isVisible();
        assertThat(driver.locator(cartButtonOnDetails)).isVisible();
    }

    public void verifyProductPage() {
        assertThat(driver.locator(titleProductPage)).hasText(titleProductPageText);
    }

    public void selectPriceLowToHigh() {
        driver.locator(filterButton).selectOption(new SelectOption().setIndex(2));
    }
}
