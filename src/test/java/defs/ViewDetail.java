package defs;

import pages.*;
import io.cucumber.java.en.*;

public class ViewDetail extends CommonSteps {
    private DetailPage detailpage;

    @Given("User searches for a keyword")
    public void user_searches_a_keyword() throws Throwable {
        driver.get("https://tiki.vn/");
        homepage = new HomePage(driver);
        homepage.closePromotion();
        homepage.clickAccountLink();
        homepage.clickLoginByEmailLink();
        homepage.inputRightCredentials();
        homepage.clickLoginButton();
        Thread.sleep(10000);  // Wait for 10 seconds or adjust based on your need
        homepage.promotionIsDisplayed();
        homepage.search();
    }
    @When("User click on product")
    public void User_click_product() throws Throwable{
        detailpage = new DetailPage(driver);
        detailpage.getDetail();
    }

    @Then("Product's detail is displayed")
    public void Product_detail_displayed() throws Throwable{
        detailpage.productDetailIsDisplayed();
        detailpage.goToCart();
    }

    @Given("User is on detail page")
    public void user_on_detail_page() throws Throwable {
        driver.get("https://tiki.vn/");
        homepage = new HomePage(driver);
        homepage.closePromotion();
        homepage.clickAccountLink();
        homepage.clickLoginByEmailLink();
        homepage.inputRightCredentials();
        homepage.clickLoginButton();
        Thread.sleep(10000);  // Wait for 10 seconds or adjust based on your need
        homepage.promotionIsDisplayed();
        homepage.search();
        detailpage = new DetailPage(driver);
        detailpage.getDetail();
    }

    @When("User adds the quantity of the product")
    public void user_adds_product() throws Throwable {
        detailpage.addMoreProduct();
    }

    @Then("Product's price is calculate correctly")
    public void product_is_calculated_correctly() throws Throwable {
        detailpage.calculateTotalPrice();
    }
}
