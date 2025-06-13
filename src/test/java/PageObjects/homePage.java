package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class homePage {
    public By Next = By.xpath("//android.widget.TextView[@text=\"NEXT\"]");
    public By GetStarted = By.xpath("//android.widget.TextView[@text=\"GET STARTED\"]");
    public By AgreeAndContinue = By.xpath("//android.widget.TextView[@text=\"AGREE AND CONTINUE\"]");
    public By India = By.xpath("//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/countryButton\" and @text=\"India\"]");
    public By Goa = By.xpath("//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/stateRadioButton\" and @text=\"Goa\"]");
    public By search = By.xpath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/searchPatientsButton\"]");
    public By newPatient = By.xpath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/newPatientButton\"]");
    public By Male = By.xpath("//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/maleRadioButton\"]");
    public By Female = By.xpath("//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/femaleRadioButton\"]");
    public By save = By.xpath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/saveButton\"]");

    // Generic Yes and No locators can’t be used reliably unless scoped properly
    // Instead, it's better to use dynamic XPaths like the getYesChipXPath() approach mentioned before
    // However, for placeholder:
//    @FindBy(xpath = "(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/yesChip\"])")
//    public By Yes;
//
//    @FindBy(xpath = "(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/noChip\"])")
//    public By No;

    public By next = By.xpath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/nextButton\"]");

    public By Diagnosis_Hypertension_Yes = By.xpath("(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/diagnosisYesChip\"])[1]");
    public By Diagnosis_Hypertension_No = By.xpath("(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/diagnosisNoChip\"])[1]");
    public By Diagnosis_Diabetes_Yes = By.xpath("(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/diagnosisYesChip\"])[2]");
    public By Diagnosis_Diabetes_No = By.xpath("(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/diagnosisNoChip\"])[2]");
    public By Diagnosis_HeartAttack_Yes = By.xpath("(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/yesChip\"])[1]");
    public By Diagnosis_HeartAttack_No = By.xpath("(//android.view.ViewGroup[@resource-id=\"org.simple.clinic.staging:id/chipGroup\"])[1]");
    public By Diagnosis_Stroke_Yes = By.xpath("(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/yesChip\"])[2]");
    public By Diagnosis_Stroke_No = By.xpath("(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/noChip\"])[2]");
    public By Diagnosis_KidneyDisease_Yes = By.xpath("(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/yesChip\"])[3]");
    public By Diagnosis_KidneyDisease_No = By.xpath("(//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/noChip\"])[3]");

    public By next1=By.xpath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/nextButton\"]");

    public By done = By.xpath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/doneButton\"]");
public By allow=By.xpath( "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");
public By notNow=By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]");
public By fistPatient=By.xpath("//androidx.cardview.widget.CardView[@resource-id=\"org.simple.clinic.staging:id/patientSearchResultView\"]/android.widget.LinearLayout");
}
