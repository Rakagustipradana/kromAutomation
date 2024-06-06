package page.utils;

import com.microsoft.playwright.Page;
import stepdefinitions.commonSetup;
import static stepdefinitions._Hooks.getCurrentScenario;

public final class Captures extends commonSetup {

    public static void takeFullScreenShot(Page driver) {
        byte[] buffer = driver.screenshot();
        String Base64 = java.util.Base64.getEncoder().encodeToString(buffer);
        ExtentReport.insertCapture(Base64);
        getCurrentScenario().attach(buffer, "image/png", ""); //insertCaptureToCucumberReport
    }
}
