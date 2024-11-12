package defs;

import io.cucumber.java.en.*;
import pages.HomePage;
public class Login extends CommonSteps {
    private HomePage homepage;

    @Given("User access URL")
    public void user_access_URL() throws Throwable {
        driver.get("https://tiki.vn/");
        homepage = new HomePage(driver);
    }
    @And("User close promotion")
    public void user_close_promotion() throws  Throwable{
        homepage.closePromotion();
    }

    @And("User click on Account link")
    public void user_clicks_accountLink() throws Throwable {
        homepage.clickAccountLink();
    }

    @And("User click on Login by email")
    public void user_click_Login_email() throws Throwable {
        homepage.clickLoginByEmailLink();
    }

    @When("User input right credentials")
    public void user_input_right_credentials() throws Throwable {
        homepage.inputRightCredentials();
    }

    @When("User input wrong credentials")
    public void user_input_wrong_credentials() throws Throwable {
        homepage.inputWrongCredentials();
    }

    @And("User click on Login button")
    public void user_click_Login_button() throws Throwable {
        homepage.clickLoginButton();
    }

    @And("User solves CAPTCHA manually")
    public void solveCaptchaManually() throws Throwable {
        Thread.sleep(10000);  // Wait for 10 seconds or adjust based on your need
    }

    @Then("User login successfully")
    public void User_login_Successfully(){
        homepage.promotionIsDisplayed();
    }

    @Then("Error message is displayed as expected")
    public void errorIsDisplayed() {
        homepage.errorIsDisplayed();
    }


}
