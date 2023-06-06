package techproed.day07_MavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        Ödev
//        1.http://zero.webappsecurity.com sayfasina gidin
          driver.get("http://zero.webappsecurity.com");
//        2.Signin buttonuna tiklayin
          driver.findElement(By.xpath("//button[@id='signin_button']")).click();
//        3.Login alanine “username” yazdirin
          driver.findElement(By.xpath("//*[@tabindex='1']")).sendKeys("username");

//        4.Password alanine “password” yazdirin
        driver.findElement(By.xpath("//*[@tabindex='2']")).sendKeys("password");
//        5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        driver.navigate().back();
//        6.Online Banking altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//strong)[2]")).click();
//        7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("(//span[@id='pay_bills_link'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("100");
//        8.tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@class='span4 hasDatepicker']")).sendKeys("2020-09-10");
//        9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
//        10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        System.out.println("Is payment succesfull? " +driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']")).isDisplayed());

    }
}
