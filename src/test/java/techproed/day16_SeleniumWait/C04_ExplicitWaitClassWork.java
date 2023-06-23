package techproed.day16_SeleniumWait;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C04_ExplicitWaitClassWork extends TestBase {
    @Test
    public void test01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        //Click me to open an Alert buttonuna basalım
        driver.findElement(By.xpath("//*[@id='alert']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        //alert çıkana kadar bekleyecek

        //Çıkan Alert'ü kapatalım
        acceptAlert();

    }

    @Test
    public void test02() {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        WebElement button = driver.findElement(By.id("populate-text"));
        button.click();
        WebElement changedText = driver.findElement(By.xpath("//*[text()='Selenium Webdriver']"));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200));
        wait.until(ExpectedConditions.visibilityOf(changedText));
    }

    @Test
    public void test03() {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        WebElement button = driver.findElement(By.id("display-other-button"));
        button.click();
        WebElement hiddenButton = driver.findElement(By.id("hidden"));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(hiddenButton));
    }

    @Test
    public void test04() {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        WebElement mainBtn = driver.findElement(By.id("enable-button"));
        mainBtn.click();
        WebElement disabledBtn = driver.findElement(By.id("disable"));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(disabledBtn));
    }

    @Test
    public void test05() {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        WebElement mainBtn = driver.findElement(By.id("checkbox"));
        mainBtn.click();
        WebElement checkBox = driver.findElement(By.id("ch"));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeSelected(checkBox));
    }
}
