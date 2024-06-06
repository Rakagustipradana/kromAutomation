package page.object;

import com.microsoft.playwright.Page;
import junit.framework.TestCase;
import page.utils.Captures;

import static driver.driverFactory.getWebDriver;

public class basePage {

    Page driver = getWebDriver();

    double Timeout = 10000;

    public void scrollUp() {
        driver.evaluate("window.scrollBy(0,-500);");
    }

    public void captureScreen() { Captures.takeFullScreenShot(driver); }

    public void clickOnButton(String element) {
        try {
            driver.waitForSelector(element);
            driver.locator(element).click();
        } catch (Exception e) {
            TestCase.fail(e.getMessage());
        }
    }

    public void sendKeys(String element, String data) {
        try {
            driver.waitForSelector(element);
            driver.locator(element).fill(data);
        } catch (Exception e) {
            TestCase.fail(e.getMessage());
        }
    }
}
