package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    @Given("User is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String string, String string2) {
        System.out.println("Abc");
    }
    @When("Clicks on the login button")
    public void clicks_on_the_login_button() {

    }
    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {

    }


}