package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_SetAttribute extends TestBase {
    @Test
    public void test01() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Arama kutusuna QA yaz
        /*
        <input> tag'ına sahip webelementlere değer gönderirken sendKeys() methodu kullanırız
        sendKeys() methodu ile değer gönderemediğimiz durumlarda js executor ile rahatlıkla
        değer gönderebiliriz.
        <input> taglarında value attributu değeri, arama kutusu içindeki veriyi temsil eder
         */
        WebElement arama = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'", arama); //--> value attribute değer olarak QA yazdır.
    }

    @Test
    public void test() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Arama kutusuna QA yaz
        WebElement arama = driver.findElement(By.xpath("//*[@type='search']"));
        jsSendKeys("Java", arama);
         }

    @Test
    public void test03() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Arama kutusuna QA yaz
        /*
        JS executer ile bir attribute değer atayabiliriz. aşağıdaki örnekteki gibi
        sayfadaki arama kutusunu locate edip arama kutusunun value attribute une 'QA' değerini atarız
        value attribiture', bir html etiketidir. ona değer atıyoruz.
 */
        WebElement arama = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', 'QA')", arama);
    }

    @Test
    public void test04() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Arama kutusuna QA yaz
        WebElement arama = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id', 'erol')", arama); //--> id değerini değiştirdik.
        driver.findElement(By.id("erol")).sendKeys("Java", Keys.ENTER);
    }

    @Test
    public void test05() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Arama kutusuna QA yaz
        WebElement arama = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
       jsSetAttribute("value", "QA", arama);//--> Method ile attribute değerini set ettik.

    }
}

