package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Alerts extends TestBase {
    @Test
    public void text01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println(getTextAlert());//-->TestBase class'ında oluşturmuş olduğumuz method
        Assert.assertEquals("You clicked a button", getTextAlert());
        bekle(2);
        //Ve alert'ü kapatalım
        acceptAlert(); //-->TestBase class'ında oluşturmuş olduğumuz method
    }

    @Test
    public void test02() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.findElement(By.xpath("(//button)[4]")).click();
        bekle(2);
        //Çıkan alertte iptale basalım.
        dismissAlert();
        // Sonuç yazısında You selected Cancel yazdığını doğrulayalım
        String sonuc = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel", sonuc);
    }

    @Test
    public void test03() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[5]")).click();
        //çıkan alerte ismimizi girelim
        sendKeysAlert("Oguzhan");
        bekle(2);
        acceptAlert();
        //ismi girdiğimizi doğrulayalım
        String isim = driver.findElement(By.id("promptResult")).getText();
        System.out.println(isim);
        Assert.assertTrue(isim.contains("Oguzhan"));
    }
}
