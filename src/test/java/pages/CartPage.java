package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import pages.DetailPage;

public class CartPage {
    private WebDriver driver;
    private DetailPage detailPage;
    private String getname;
    private String getunitprice;
    private String unitpriceoncart;

    public CartPage(WebDriver driver, DetailPage detailPage) {
        this.driver = driver;
        this.detailPage = detailPage;
        this.getname = detailPage.get_product_name();
        this.getunitprice = detailPage.get_product_unit_price();
    }
    By productNameOnCart = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[1]/div/a");
    By quantityOnCart = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/div/input");
    By unitPriceOnCart = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[1]");
    By priceOnCart = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[4]");
    By totalAmount = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[2]/div/div[2]/div/div/span[1]");
    By buyBtn = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[2]/div/div[2]/button");

    public void click_Buy() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buy = wait.until(ExpectedConditions.elementToBeClickable(buyBtn));
        buy.click();
    }

    public void verify_chosen_product_name() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String productnameoncart = wait.until(ExpectedConditions.visibilityOfElementLocated(productNameOnCart)).getText();
        Assert.assertEquals("Product name is not match", getname, productnameoncart);
    }

    public void verify_chosen_product_unitprice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        unitpriceoncart = wait.until(ExpectedConditions.visibilityOfElementLocated(unitPriceOnCart)).getText().replaceAll("[^0-9.]", "");
        Double doubleunitpriceoncart = Double.parseDouble(unitpriceoncart);
        Double doublegetunitprice = Double.parseDouble(getunitprice);
        Assert.assertEquals("Unit price is not match",doublegetunitprice,doubleunitpriceoncart);
    }

    public void verify_chosen_total_price() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String quantityoncart = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityOnCart)).getAttribute("value");
        int intquantityoncart = Integer.parseInt(quantityoncart);

        String priceoncart = wait.until(ExpectedConditions.visibilityOfElementLocated(priceOnCart)).getText().replaceAll("[^0-9.]", "");
        double doublepriceoncart = Double.parseDouble(priceoncart);

        double doubleunitpriceoncart = Double.parseDouble(unitpriceoncart);

        double expectedPrice = doubleunitpriceoncart * intquantityoncart;

        Assert.assertEquals("Total price is not correct!", expectedPrice, doublepriceoncart,0.01);
    }

}

