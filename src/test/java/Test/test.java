package Test;

import AppiumDemo.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test extends BaseClass {
    ExtentTest test;
    //BaseClass b = new BaseClass();
    @Test(priority = 1)
    public void homeScreen() {
        try {
            test = extent.createTest("Home Screen");
            test.info("Tapping on next tab");
            tapOn(driver,"//android.widget.TextView[@text=\"NEXT\"]");
            //next.click();
            test.info("Tapping on Get started tab");
            tapOn(driver,"//android.widget.TextView[@text=\"GET STARTED\"]");
            //getStarted.click();
            test.info("Tapping on Agree and continue tab");
            tapOn(driver,"//android.widget.TextView[@text=\"AGREE AND CONTINUE\"]");
            //agree.click();
            test.info("Tapping on India tab");
            tapOn(driver,"//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/countryButton\" and @text=\"India\"]");
            // country.click();
            //  test.log(Status.INFO, "Tapping on city tab");
            test.info("Tapping on city tab");
            tapOn(driver,"//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/stateRadioButton\" and @text=\"Goa\"]");
            //clinic.click();
            test.pass("Test case passed successfully");
        } catch (Exception e) {
            test.fail("Test case Failed");
        }
    }

    @Test(priority = 2, dataProvider = "loginData")
    public void loginTest(String phone, String pin) {
        test=extent.createTest("Login Test");

        enterValue(phone,"//android.widget.EditText[@resource-id='org.simple.clinic.staging:id/phoneNumberEditText']",driver);
//        phoneNo.click();
//        phoneNo.sendKeys(phone);
        tapOn(driver,"//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/nextButton\"]");
        //next.click();
        enterValue(pin,"//android.widget.EditText[@resource-id='org.simple.clinic.staging:id/pinEditText']",driver);
//        pinField.click();
//        pinField.sendKeys(pin);
        try {
            MobileElement elem = driver.findElementByXPath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");
            if (elem.isDisplayed()) {
                elem.click();
            }
        } catch (Exception e) {
            // Element not present or not visible, no action needed
        }
        test.pass("Test case pass");
    }

    @Test(priority = 3, dataProvider = "patient", dataProviderClass = BaseClass.class)
    public void register(String name, String age, String gender, String phoneNumber,
                         String address, String ward, String district, String state,
                         String hypertension, String diabetes, String heartAttack,
                         String stroke, String kidneyDisease) {
//        List<MobileElement> allowButtons = driver.findElementsByXPath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']");
//        if (!allowButtons.isEmpty()) {
//            allowButtons.get(0).click();
//        }
        test=extent.createTest("Register Test");
        tapOn(driver, "//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/searchPatientsButton\"]");

        tapOn(driver, "//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/newPatientButton\"]");

        enterValue(name,"//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/fullNameEditText\"]",driver);
        //Pname.click();
//        System.out.println(name);
//        Pname.sendKeys(name);
       enterValue(age,"//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/ageEditText\"]",driver);
//        Age.click();
//        System.out.println(age);
//        Age.sendKeys(age);
        if (gender.equalsIgnoreCase("M")) {
            tapOn(driver,"//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/maleRadioButton\"]");
//            male.click();
        } else {
           tapOn(driver,"//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/femaleRadioButton\"]");
            //female.click();
        }
        enterValue(phoneNumber,"//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/phoneNumberEditText\"]",driver);
//        phone.click();
//        phone.sendKeys(phoneNumber);
        enterValue(address,"//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/streetAddressEditText\"]",driver);
//        add.click();
//        add.sendKeys(address);
        enterValue(ward,"//android.widget.AutoCompleteTextView[@resource-id=\"org.simple.clinic.staging:id/colonyOrVillageEditText\"]",driver);
//        Ward.click();
//        Ward.sendKeys(ward);
        enterValue(district,"//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/districtEditText\"]",driver);
//        dis.sendKeys(district);
        enterValue(state,"//android.widget.EditText[@resource-id=\"org.simple.clinic.staging:id/stateEditText\"]",driver);
//        State.sendKeys(state);
        tapOn(driver,"//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/saveButton\"]");
       //next.click();
        if (hypertension.equalsIgnoreCase("Yes")) {
            tapOn(driver,"(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/diagnosisYesChip\"])[1]");
        } else {
            tapOn(driver,"(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/diagnosisNoChip\"])[1]");
        }
        if (diabetes.equalsIgnoreCase("Yes")) {
            tapOn(driver,"(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/diagnosisYesChip\"])[2]");
        } else {
            tapOn(driver,"(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/diagnosisNoChip\"])[2]");
        }
        if (heartAttack.equalsIgnoreCase("Yes")) {
            tapOn(driver,"(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/yesChip\"])[1]");
        } else {
            tapOn(driver,"(//android.view.ViewGroup[@resource-id=\"org.simple.clinic.staging:id/chipGroup\"])[1]");
        }
        if (stroke.equalsIgnoreCase("Yes")) {
            tapOn(driver,"(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/yesChip\"])[2]");
        } else {
            tapOn(driver,"(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/noChip\"])[2]");
        }
        if (kidneyDisease.equalsIgnoreCase("Yes")) {
            tapOn(driver,"(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/yesChip\"])[3]");
        } else {
            tapOn(driver,"(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/noChip\"])[3]");
        }
        tapOn(driver,"//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/nextButton\"]");
       // next1.click();
        tapOn(driver,"//android.widget.Button[@resource-id=\"android:id/button2\"]");
        //Not.click();
        tapOn(driver,"//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/doneButton\"]");
        //save.click();
        test.pass("Register success");

    }

    @Test(priority = 4, dataProvider = "patient", dataProviderClass = BaseClass.class)
    public void testAddedPatient(String name, String age, String gender, String phoneNumber,
                                 String address, String ward, String district, String state,
                                 String hypertension, String diabetes, String heartAttack,
                                 String stroke, String kidneyDisease) throws InterruptedException {
        test = extent.createTest("Verify Added Patient Details");
        SoftAssert as=new SoftAssert();
        Thread.sleep(1000);
        tapOn(driver,"//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/searchPatientsButton\"]");
       // searchElem.click();
        tapOn(driver,"//androidx.cardview.widget.CardView[@resource-id=\"org.simple.clinic.staging:id/patientSearchResultView\"]/android.widget.LinearLayout");
        //card.click();
        MobileElement title = driver.findElementByXPath("//android.widget.TextView[@resource-id=\"org.simple.clinic.staging:id/fullNameTextView\"]");
        String title1=title.getText();
        String first =title1.split(",")[0].trim();
        String sec=title1.split(",")[1].trim();
        String third=title1.split(",")[2].trim();
        MobileElement add=driver.findElementByXPath("//android.widget.TextView[@resource-id=\"org.simple.clinic.staging:id/addressTextView\"]");
        String Address=add.getText();
        System.out.println(Address);
        String f1=Address.split(",")[0].trim();
        String f2=Address.split(",")[1].trim();
        String f3=Address.split(",")[2].trim();
        String f4=Address.split(",")[3].trim();
        verifyIsDisplayed("//android.widget.ImageButton[@content-desc=\"Go back\"]",driver,test);
        verifyIsDisplayed("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/contactTextView\"]",driver,test);
        verifyIsDisplayed("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/editPatientButton\"]",driver,test);
        //System.out.println("Name,gender,age displayed or not ");
        verifyIsDisplayed("//android.widget.TextView[@resource-id=\"org.simple.clinic.staging:id/fullNameTextView\"]",driver,test);
        //System.out.println("Address");
        verifyIsDisplayed("//android.widget.TextView[@resource-id=\"org.simple.clinic.staging:id/addressTextView\"]",driver,test);
        verifyIsPresent(first,name,test);
        verifyIsPresent(sec,gender,test);
        verifyIsPresent(third,age,test);
        verifyIsPresent(f1,address,test);
        verifyIsPresent(f2,ward,test);
        verifyIsPresent(f3,district,test);
        verifyIsPresent(f4,state,test);
    }

}
