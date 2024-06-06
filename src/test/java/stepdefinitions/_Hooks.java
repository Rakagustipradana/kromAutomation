package stepdefinitions;

import com.microsoft.playwright.Page;
import driver.driverFactory;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.*;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import page.utils.Captures;
import page.utils.ExtentReport;

import static driver.driverFactory.browser;
import static driver.driverFactory.getWebDriver;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class _Hooks extends commonSetup {

    static ExtentReport extentReport = new ExtentReport();
    public driverFactory driverFactory;
    public Page page;
    private static Scenario CurrentScenario;
    public static int stepDefIndex = 0;
    int sizeStep;

    @Before
    public void open(Scenario scenario) throws IOException {
        double TimeOut = 3000;
        setCurrentScenario(scenario);
        extentReport.extentReports();
        extentReport.CreateScenario(scenario).assignAuthor("Raka");
        driverFactory = new driverFactory();
        page = getWebDriver();
        page.navigate(this.GetProperties("homePageURL"), new Page.NavigateOptions().setTimeout(TimeOut));
    }

    @BeforeStep
    public void grabTestStep() throws Exception {
        String currentStepDescr, currentKeywordDesc = null;
        Field fDelegate = getCurrentScenario().getClass().getDeclaredField("delegate");
        fDelegate.setAccessible(true);
        TestCaseState tcs = (TestCaseState) fDelegate.get(getCurrentScenario());
        Field fTestCase = tcs.getClass().getDeclaredField("testCase");
        fTestCase.setAccessible(true);
        TestCase cases = (TestCase) fTestCase.get(tcs);

        List<PickleStepTestStep> stepDefs = cases.getTestSteps().stream()
                .filter(x -> x instanceof PickleStepTestStep)
                .map(x -> (PickleStepTestStep) x)
                .collect(Collectors.toList());

        sizeStep = stepDefs.size();
        PickleStepTestStep currentStepDef = stepDefs.get(stepDefIndex);
        currentKeywordDesc = currentStepDef.getStep().getKeyword();
        currentStepDescr = currentStepDef.getStep().getText();
        extentReport.CreateStep(currentKeywordDesc +" "+ currentStepDescr);
        System.out.println(currentKeywordDesc +" "+currentStepDescr);

    }


    @AfterStep
    public void indexingStep() {
        stepDefIndex = stepDefIndex + 1;
        if (stepDefIndex == sizeStep) {
            stepDefIndex = 0;
        }
    }

    @After
    public void close() {
        if (page != null) {
            if (getCurrentScenario().isFailed()) {
                Captures.takeFullScreenShot(page);
                page.close(new Page.CloseOptions().setRunBeforeUnload(true));
                browser.close();
                stepDefIndex = 0;
            }
        }
        extentReport.saveReport();
    }

    public static Scenario getCurrentScenario() {
        return CurrentScenario;
    }

    public static void setCurrentScenario(Scenario currentScenario) {
        CurrentScenario = currentScenario;
    }
}
