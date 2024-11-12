package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPage {
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    By title = By.xpath("//*[@id=\"__next\"]/div[2]/header/div/div[1]/span[2]");

    public void verifyTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds
        String titlePayment = wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText(); // Wait until the button is clickable
        Assert.assertEquals("Payment oage is not displayed", "Thanh toán", titlePayment);
    }
}


