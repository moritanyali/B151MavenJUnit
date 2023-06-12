package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Alerts extends TestBase {

        /*
    Eğer bir sayfadaki bir buttona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye sağ klip
 yapıp locate alamıyorsak, bu bir js Alert'tür.
    js Alert'ü handle edebilmek için driver'ımızı o pencere geçirmemiz gerekir. Bunun için;
 driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e geçiş yapmış oluruz
 accept() yada dismiss() methodlarıyla js Alert'ü onaylar yada iptal ederek kapatırız
          accept() --> onaylar
         dismiss() --> iptal eder
 */

    @Test
    public void acceptAllert() {
        //Bir metod olusturun: acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        bekle(2);
        driver.switchTo(). //geçmek için kullanılan method
                alert(). //alert'e geçiş yapar
                accept(); //çıkar alert'te ok ya da tamam butonuna tıklar.
        String expectedResMsg = "You successfully clicked an alert";
        String actualMsg = driver.findElement(By.xpath("(//p)[2]")).getText();
        Assert.assertEquals(actualMsg, expectedResMsg);
    }

    @Test
    public void dismissAlert() {
        //Bir metod olusturun: dismissAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(2);
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();
        bekle(2);
        driver.switchTo().
                alert().
                dismiss();//alert'teki cancel'a basar
        //“successfuly” icermedigini test edin.
        String unexpectedWord = "succesfully";
        String actualMsg = driver.findElement(By.xpath("(//p)[2]")).getText();
        Assert.assertFalse(actualMsg.contains(unexpectedWord));
    }

    @Test
    public void sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
        driver.switchTo().alert().sendKeys("Oguzhan AYDIN");
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement isim = driver.findElement(By.xpath("(//p)[2]"));
        String expectedName = "Oguzhan AYDIN";
        Assert.assertTrue(isim.getText().contains(expectedName));
    }
}
