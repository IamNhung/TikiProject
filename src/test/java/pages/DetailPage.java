package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DetailPage {
    private WebDriver driver;
    private String outerProductName;
    private String innerProductName;

    public DetailPage(WebDriver driver) {
        this.driver = driver;
    }

    By productName = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div/a/span/div[2]/div[1]/div[2]/div[1]/h3");
    By productNameDetail = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div[1]/div/div/div[1]/h1");
    By priceDetail = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div");
    By quantityDetail = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div/input");
    By unitPriceDetail = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div[1]/div/div/div[2]/div/div/div");
    By add = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div/button[2]");
    By addToCart = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[3]/button[2]");
    By successfulMessage = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[2]/div[3]/div");
    By linkToCart = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[2]/div[3]/div/a[2]");

    public void getDetail () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds
        WebElement productNameElement = wait.until(ExpectedConditions.elementToBeClickable(productName)); // Wait for product name visibility
        outerProductName = productNameElement.getText();
        productNameElement.click();
    }

    public void productDetailIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productnamedetail = wait.until(ExpectedConditions.visibilityOfElementLocated(productNameDetail));
        innerProductName = productnamedetail.getText();
        Assert.assertEquals("Name of chosen product is not match name of detail product",innerProductName,outerProductName);
    }

    public String get_product_name(){
        return innerProductName;
    }

    public String get_product_unit_price(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String getproductunitpricedetail = wait.until(ExpectedConditions.visibilityOfElementLocated(unitPriceDetail)).getText().replaceAll("[^0-9.]", "");
        return getproductunitpricedetail;
    }

    public void addMoreProduct() {
        driver.findElement(add).click();
    }

    public void calculateTotalPrice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(unitPriceDetail));
        String priceText = priceElement.getText().replaceAll("[^0-9.]", "");
        double productPriceValue = Double.parseDouble(priceText);

        WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityDetail));
        String quantityText = quantityElement.getText();  // Quantity is an input field
        int quantityValue = Integer.parseInt(quantityText);

        double expectedTotal = productPriceValue * quantityValue;

        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(priceDetail));
        String totalText = totalElement.getText().replaceAll("[^0-9.]", "");  // Remove any non-numeric characters
        double displayedTotal = Double.parseDouble(totalText);

        Assert.assertEquals("Total price is not correct!", expectedTotal, displayedTotal,0.01);
    }

    public String get_product_quantity(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement getproductquantityoncart = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityDetail));
        return getproductquantityoncart.getText();
    }

    public String get_product_price(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement getproductpriceoncart = wait.until(ExpectedConditions.visibilityOfElementLocated(priceDetail));
        return getproductpriceoncart.getText();
    }
    public void addtoCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addtocart = wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addtocart.click();
    }

    public void messageAddtoCartisDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement successfulmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successfulMessage));
        if(!successfulmessage.isDisplayed()){
            Assert.fail("Add to unsuccessfully");
        }
    }

    public void goToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linktocart = wait.until(ExpectedConditions.elementToBeClickable(linkToCart));
        linktocart.click();
    }

}
