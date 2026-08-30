package Seleniumdailypratics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSearchTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.google.com");
    }

    @Test
    public void GoogleSearchTest() {

        WebElement searchBox =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

        searchBox.sendKeys("selenium");

        searchBox.submit();

        wait.until(ExpectedConditions.titleContains("selenium"));

        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        System.out.println("Page title: " + title);
        System.out.println("Current URL: " + url);

        Assert.assertTrue(url.contains("google"), "URL validation failed...");

        System.out.println("Google search test passed....");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}




