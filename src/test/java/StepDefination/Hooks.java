package StepDefination;

import AppiumDemo.BaseClass;
import AppiumDemo.ReportManager;
import AppiumDemo.Utility;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static AppiumDemo.BaseClass.*;

public class Hooks {

    @Before
    public void init(Scenario scenario) throws Exception {
        BaseClass.setup();
        BaseClass.test = ReportManager.getReporter().createTest(scenario.getName());
        System.out.println("Starting Scenario: " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        String screenshotPath = Utility.takeScreenshot(driver, scenario.getName().replaceAll(" ", "_") + "_Step");
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Step failed",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.INFO, "Step passed",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        String screenshotPath = Utility.takeScreenshot(driver, scenario.getName().replaceAll(" ", "_"));
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Scenario Failed: " + scenario.getName(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(Status.PASS, "Scenario Passed: " + scenario.getName(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        System.out.println("Ending Scenario: " + scenario.getName());
        driver.quit();
    }

}
