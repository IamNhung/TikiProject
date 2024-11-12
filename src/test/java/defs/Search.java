package defs;

import io.cucumber.java.en.*;
import pages.*;

public class Search extends CommonSteps{
    private HomePage homepage;

    @Given("User is on the homepage")
    public void user_is_on_homepage() throws Throwable {
        driver.get("https://tiki.vn/");
        homepage = new HomePage(driver);
        homepage.closePromotion();
        homepage.clickAccountLink();
        homepage.clickLoginByEmailLink();
        homepage.inputRightCredentials();
        homepage.clickLoginButton();
        Thread.sleep(10000);  // Wait for 10 seconds or adjust based on your need
        homepage.promotionIsDisplayed();
    }
    @When("User searches for a valid keyword")
    public void User_searches_for_validkeyword() throws Throwable{
        homepage.search();
    }
    @Then("Results related to keyword are displayed")
    public void Results_related_to_keyword_displayed() throws Throwable{
        homepage.verifyResult();
    }
}
