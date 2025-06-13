package StepDefination;

import AppiumDemo.BaseClass;
import AppiumDemo.Utility;
import PageObjects.homePage;
import Test.test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class simpleClinic extends BaseClass {
    AndroidDriver<MobileElement> driver = BaseClass.driver;
    ExtentReports extent =BaseClass.extent;
    ExtentTest test=BaseClass.test;
   // ExtentTest test=extent.createTest("Home Screen ");
    homePage home=new homePage();
    Utility u = new Utility();

    @DataProvider(name = "patient")
    public Object[][] getHealthData() throws IOException {
        return readExcel("src/main/patientInfo (3).xlsx", "Sheet1");
    }
    @Given("I am on the home screen")
    public void i_am_on_the_home_screen() {

        System.out.println("App launched and on home screen");
        logInfo(test,"user is on home page");
    }
    @When("I tap on NEXT")
    public void i_tap_on_next() {
        // Write code here that turns the phrase above into concrete actions

        u.tapOn(driver,home.Next,test,"user click on next tab");
        logInfo(test,"User click on next Tab");
        takeScreenshot(driver,"Tap on next btn");
    }
    @When("I tap on GET STARTED")
    public void i_tap_on_get_started() {
        // Write code here that turns the phrase above into concrete actions
        u.tapOn(driver,home.GetStarted,test,"User click on get started btn");
        logInfo(test,"user click on get Started btn");
    }
    @When("I tap on AGREE AND CONTINUE")
    public void i_tap_on_agree_and_continue() {
        // Write code here that turns the phrase above into concrete actions
        u.tapOn(driver,home.AgreeAndContinue,test,"user click on agree and continue");
        logInfo(test,"user click on agree and continue");
    }
    @When("I select country as {string}")
    public void i_select_country_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        u.tapOn(driver,home.India,test,"user click on India tab");
        logInfo(test,"user clicks on india tab");
    }
    @When("I select state as {string}")
    public void i_select_state_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        u.tapOn(driver,home.Goa,test,"user click on Goa tab");
        logInfo(test,"user click on Goa tab");
    }
    @Then("I should be navigated to the login screen")
    public void i_should_be_navigated_to_the_login_screen() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user is on login page");
        logInfo(test,"user is on login screen");
        verifyIsDisplayed("//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/phoneNumberEditText\"]",driver,test);
        //logStepStatus(test,driver.findElementByXPath("//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/phoneNumberEditText\"]").isDisplayed(),"Login page doesn't display","Login page displayed");
    }
    @Given("I am on login page")
    public void i_am_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
//        MobileElement phone= driver.findElementByXPath("//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/phoneNumberEditText\"]");
//        Assert.assertTrue(phone.isDisplayed());
        System.out.println("Login page");
    }
    @When("Enter the phoneNo {string}")
    public void enter_the_phone_no(String phone) {
        // Write code here that turns the phrase above into concrete actions
        MobileElement phone1= driver.findElementByXPath("//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/phoneNumberEditText\"]");
        phone1.sendKeys(phone);
        logInfo(test,"user enter the mobile no.");

    }
    @When("Click on next button")
    public void click_on_next_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElementByXPath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/nextButton\"]").click();
    }
    @When("Enter the pin {string}")
    public void enter_the_pin(String pin) {
        // Write code here that turns the phrase above into concrete actions
        MobileElement Pin = driver.findElementByXPath("//android.widget.EditText[@resource-id='org.simple.clinic.staging:id/pinEditText']");
        Pin.sendKeys(pin);

    }
    @Then("User is on dashboard page")
    public void user_is_on_dashboard_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is on home page");
    }

    @Given("user is on dashboard")
    public void user_is_on_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Dashboard");

    }
    @When("user click on allow")
    public void user_click_on_allow() {
        // Write code here that turns the phrase above into concrete actions
        try {
            MobileElement elem = driver.findElementByXPath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");
            if (elem.isDisplayed()) {
                elem.click();
            }
        } catch (Exception e) {
            // Element not present or not visible, no action needed
        }
    }
    @When("click on search icon")
    public void click_on_search_icon() {
        // Write code here that turns the phrase above into concrete actions
        tapOn(driver, home.search,test,"user click on search btn");
    }

    @When("click on register as new patient")
    public void click_on_register_as_new_patient() {
        // Write code here that turns the phrase above into concrete actions
        tapOn(driver, home.newPatient,test,"User click on register patient");
    }

    @When("enter the patient details from row {string}")
    public void enter_the_patient_details_from_excel(String rowIndexStr) throws IOException {
        int row = Integer.parseInt(rowIndexStr);
        Object[][] data = readExcel("src/main/patientInfo.xlsx", "Sheet1");

        // Assuming columns are in order: name, age, gender, phoneNumber, address, ward, district, state, hypertension, diabetes, heartAttack, stroke, kidneyDisease
        String name = data[row - 1][0].toString();
        String age = data[row - 1][1].toString();
        String gender = data[row - 1][2].toString();
        String phoneNumber = data[row - 1][3].toString();
        String address = data[row - 1][4].toString();
        String ward = data[row - 1][5].toString();
        String district = data[row - 1][6].toString();
        String state = data[row - 1][7].toString();
        String hypertension = data[row - 1][8].toString();
        String diabetes = data[row - 1][9].toString();
        String heartAttack = data[row - 1][10].toString();
        String stroke = data[row - 1][11].toString();
        String kidneyDisease = data[row - 1][12].toString();

        u.enterValue(name, "//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/fullNameEditText\"]", driver,test,"Full Name");
        u.enterValue(age, "//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/ageEditText\"]", driver,test,"Age");

        if (gender.equalsIgnoreCase("M")) {
            u.tapOn(driver, home.Male,test,"Click on male radio btn");
        } else {
            u.tapOn(driver, home.Female,test,"click on female radio btn");
        }

        u.enterValue(phoneNumber, "//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/phoneNumberEditText\"]", driver,test,"Phone Number");
        u.enterValue(address, "//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/streetAddressEditText\"]", driver,test,"Address");
        u.enterValue(ward, "//android.widget.AutoCompleteTextView[@resource-id=\"org.simple.clinic.staging:id/colonyOrVillageEditText\"]", driver,test,"ward");
        u.enterValue(district, "//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/districtEditText\"]", driver,test,"district");
        u.enterValue(state, "//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/stateEditText\"]", driver,test,"state");

        u.tapOn(driver, home.save,test,"user click on save btn");

        // Conditions
        if (hypertension.equalsIgnoreCase("Yes")) {
            u.tapOn(driver, home.Diagnosis_Hypertension_Yes);
        } else {
            u.tapOn(driver, home.Diagnosis_Hypertension_No);
        }

        if (diabetes.equalsIgnoreCase("Yes")) {
            u.tapOn(driver, home.Diagnosis_Diabetes_Yes);
        } else {
            u.tapOn(driver, home.Diagnosis_Diabetes_No);
        }

        if (heartAttack.equalsIgnoreCase("Yes")) {
            u.tapOn(driver, home.Diagnosis_HeartAttack_Yes);
        } else {
            u.tapOn(driver, home.Diagnosis_HeartAttack_No);
        }

        if (stroke.equalsIgnoreCase("Yes")) {
            u.tapOn(driver, home.Diagnosis_Stroke_Yes);
        } else {
            u.tapOn(driver, home.Diagnosis_Stroke_No);
        }

        if (kidneyDisease.equalsIgnoreCase("Yes")) {
            u.tapOn(driver, home.Diagnosis_KidneyDisease_Yes);
        } else {
            u.tapOn(driver, home.Diagnosis_KidneyDisease_No);
        }

        u.tapOn(driver, home.next1,test,"Click on next btn");
        u.tapOn(driver, home.notNow,test,"Click on not now");
        u.tapOn(driver, home.done,test,"Click on done btn");
    }

    @Then("patient added successfully")
    public void patient_added_successfully() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Patient added success");
        tapOn(driver,home.search,test,"Click on search btn");
        tapOn(driver,home.fistPatient,test,"Tapping on first patient");
        verifyIsDisplayed("//android.widget.ImageButton[@content-desc=\"Go back\"]",driver,test);
        verifyIsDisplayed("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/contactTextView\"]",driver,test);
        verifyIsDisplayed("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/contactTextView\"]",driver,test);
        //System.out.println("Name,gender,age displayed or not ");
        verifyIsDisplayed("//android.widget.TextView[@resource-id=\"org.simple.clinic.staging:id/fullNameTextView\"]",driver,test);
        //System.out.println("Address");
        verifyIsDisplayed("//android.widget.TextView[@resource-id=\"org.simple.clinic.staging:id/addressTextView\"]",driver,test);
    }


}
