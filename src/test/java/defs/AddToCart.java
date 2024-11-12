package defs;

import pages.CartPage;
import pages.DetailPage;
import io.cucumber.java.en.*;
import pages.HomePage;

public class AddToCart extends CommonSteps {
    private DetailPage detailpage;
    private CartPage cartpage;
    private HomePage homepage;

    @Given("User choose product")
    public void user_choose_product() throws Throwable {
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

    @When("User clicks on Add to cart button")
    public void user_clicks_cart() throws Throwable {
        detailpage.addtoCart();
    }
    @Then("Message is displayed")
    public void Message_is_displayed() throws Throwable {
        detailpage.messageAddtoCartisDisplayed();
        detailpage.goToCart();
    }

    @And("Product is displayed on cart")
    public void Product_is_displayed() throws Throwable {
        detailpage.productDetailIsDisplayed();
        cartpage = new CartPage(driver,detailpage);
        cartpage.verify_chosen_product_name();
        cartpage.verify_chosen_product_unitprice();
        cartpage.verify_chosen_total_price();
    }
}
