package defs;
import pages.CartPage;
import pages.DetailPage;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.PaymentPage;

public class Payment extends CommonSteps {
    private DetailPage detailpage;
    private CartPage cartpage;
    private PaymentPage payment;

    @Given("User added product to cart")
    public void user_added_product() throws Throwable {
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
        detailpage.addtoCart();
        detailpage.messageAddtoCartisDisplayed();
        detailpage.goToCart();
        detailpage.productDetailIsDisplayed();
        cartpage = new CartPage(driver,detailpage);
        cartpage.verify_chosen_product_name();
        cartpage.verify_chosen_product_unitprice();
        cartpage.verify_chosen_total_price();
    }

    @When("User clicks on Buy")
    public void user_clicks_buy() throws Throwable {
        cartpage.click_Buy();
    }
    @Then("Payment screen is displayed")
    public void Payment_displayed() throws Throwable {
        payment = new PaymentPage(driver);
        payment.verifyTitle();
    }
}
