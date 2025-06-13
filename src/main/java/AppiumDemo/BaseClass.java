package AppiumDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class BaseClass extends Utility {
        public static AndroidDriver<MobileElement> driver;
        public static ExtentReports extent;

    public static ExtentTest test;
        public static void setup() throws Exception {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "CPH2467");
            caps.setCapability("appPackage", "org.simple.clinic.staging");
            caps.setCapability("appActivity", "org.simple.clinic.setup.SetupActivity");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("noReset", true);

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4726/wd/hub"), caps);
//            if(extent==null) {
//
//
//                ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
//                extent = new ExtentReports();
//                extent.attachReporter(spark);
//
//                extent.setSystemInfo("Tester", "Hemant");
//                extent.setSystemInfo("Environment", "QA");
//                extent.setSystemInfo("Platform", "Android");
//            }
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }




    @DataProvider(name = "patient")
    public Object[][] getHealthData() throws IOException {
        return readExcel("src/main/patientInfo (3).xlsx", "Sheet1");
    }


    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] { {"1234567890", "1234"} };
    }


}
