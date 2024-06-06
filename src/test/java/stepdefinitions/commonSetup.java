package stepdefinitions;

import page.object.positiveNegativePage;
import page.utils.ExtentReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class commonSetup {

    private final Properties configProperties = new Properties();

//    int timeout = 90;

    positiveNegativePage positiveNegativePage = new positiveNegativePage();

//    String Path = System.getProperty("user.dir");

//    File UploadData = new File ( Path + File.separator +"src/Data/upload.txt");

    ExtentReport extentReport = new ExtentReport();

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
