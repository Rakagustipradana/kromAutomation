package page.utils;

import stepdefinitions.commonSetup;
import com.aventstack.extentreports.Status;
import static stepdefinitions._Hooks.getCurrentScenario;

public class CustomAssert extends commonSetup {

    public static void showMessage (String Title, String message) {
        getCurrentScenario().log(Title + message);//cucumberReport
        ExtentReport.CreateLogs.log(Status.INFO, Title + message);//ExtentReport
    }

    public static void stackTrace(String e) {
        System.out.println(e);
        ExtentReport.CreateLogs.log(Status.FAIL, "StackTrace Result: " +e); //extentreport
    }

}
