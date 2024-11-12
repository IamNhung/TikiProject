package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    // Constructor to initialize driver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    By closeBtn = By.xpath("//*[@id=\"VIP_BUNDLE\"]/div[2]/div/picture[1]/img");
    By accountLink = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[2]/div[2]/span");
    By LoginByEmailLink = By.xpath("/html/body/div[7]/div/div/div/div[1]/div/p");
    By emailTxt = By.name("email");
    By passTxt = By.xpath("/html/body/div[7]/div/div/div/div[1]/div/form/div[2]/input");
    By loginBtn = By.xpath("/html/body/div[7]/div/div/div/div[1]/div/form/button");
    By errorMessage = By.xpath("/html/body/div[7]/div/div/div/div[1]/div/form/span");
    By droplist = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[2]/div[2]/div");
    By searchBar = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[1]/div/div/input");
    By searchBtn = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[1]/div/div/button");
    By searchResult = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[1]/div/a[2]/span");

    public void closePromotion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closeBtn)); // Wait until the button is clickable
        closeButton.click(); // Click on the close button
    }

    public void clickAccountLink() {
        driver.findElement(accountLink).click();
    }

    public void clickLoginByEmailLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement LBEmailLink = wait.until(ExpectedConditions.elementToBeClickable(LoginByEmailLink));
        LBEmailLink.click();
    }


    public void inputRightCredentials() {
        driver.findElement(emailTxt).sendKeys("nhungvu214@gmail.com");
        driver.findElement(passTxt).sendKeys("Abc@12345");
    }

    public void inputWrongCredentials() {
        driver.findElement(emailTxt).sendKeys("nhungvu214@gmail.com");
        driver.findElement(passTxt).sendKeys("Abd@12345");
    }

    public void clickLoginButton() {
        driver.findElement(loginBtn).click();
    }

    public void promotionIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closeBtn)); // Wait until the button is clickable
        closeButton.click();
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(droplist));
    }

    public void errorIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String actualMessage = errorElement.getText();
        Assert.assertEquals(actualMessage,"Thông tin đăng nhập không đúng");
    }
    String keyword = "bút chì";
    public void search() {
        driver.findElement(searchBar).sendKeys(keyword);
        driver.findElement(searchBtn).click();
    }

    public void verifyResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
        if(!result.getText().contains(keyword)){
            Assert.fail("Search result is not match keyword");
        }
    }
}




