package driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.*;

import java.io.IOException;

public final class driverFactory {
    static Playwright playwright;

    public static Browser browser;

    public static Page driver;

    public static Page getWebDriver() {
        if (driver == null || driver.isClosed()) {
            try {
                createNewDriver();
            } catch (Exception e) {
                System.out.println("Error on creating driver");
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static Page createNewDriver() throws IOException {
        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome"));
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        driver = browser.newPage(new Browser.NewPageOptions().setIgnoreHTTPSErrors(true));

        return driver;
    }
}
