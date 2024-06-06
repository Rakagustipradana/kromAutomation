package page.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtentReport {

    private final Properties configProperties = new Properties();

    public static ExtentSparkReporter spark;

    public static ExtentReports extent = new ExtentReports();

    public static ExtentTest CreateStep;

    public static ExtentTest CreateLogs;

    private String getFeatureFileNameFromScenarioId(Scenario scenario) {
        String[] tab = scenario.getUri().toString().split("/");
        int rawFeatureNameLength = tab.length;
        String featureName = tab[rawFeatureNameLength - 1].split(":")[0];
        System.out.println("featureName: " + featureName);
        return featureName;
    }

    public ExtentReports extentReports() throws IOException {
        spark = new ExtentSparkReporter("target/Index.html"); //path result html extentreport
        extent.attachReporter(spark);
        spark.loadXMLConfig("src/test/java/page/utils/extent-config.xml");
        return extent;
    }

    public ExtentTest CreateScenario(Scenario scenario) throws IOException {
        MarkupHelper.createLabel(scenario.getName(), ExtentColor.LIME);
        CreateStep = extentReports().createTest(scenario.getName()).assignCategory(getFeatureFileNameFromScenarioId(scenario));
        return CreateStep;
    }

    public ExtentTest CreateStep(String GherkinKeyword) throws IOException {
        CreateLogs = CreateStep.createNode(GherkinKeyword);
        return CreateLogs;
    }

    public static void insertCapture(String Path) {
        CreateLogs.info(MediaEntityBuilder.createScreenCaptureFromBase64String(Path).build());
    }

    public void saveReport() { extent.flush(); }

    final String GetPathExtendReport() throws IOException {
        return getProperty("ExtentReportHtml");
    }

    private void readConfigFile() throws IOException {
        configProperties.load(new FileInputStream("Config.properties"));
    }

    private String getProperty(String key) throws IOException {
        if (configProperties.isEmpty()) {
            readConfigFile();
        }
        return configProperties.getProperty(key);
    }

    public String GetProperties(String Name) throws IOException {
        return getProperty(Name);
    }
}
