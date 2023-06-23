package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C05_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        String techHandle = driver.getWindowHandle();
        //sayfanın resmini alalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        tumSayfaResmi();
        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("java", Keys.ENTER);
        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='elementor-heading-title elementor-size-default'])[1]"));
        webElementResmi(sonucYazisi);
        //Yeni bir sekmede amazona gidelim
        bekle(2);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        //sayfanın resmini alalım
        tumSayfaResmi();
        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //ve sonuc yazısının resmini alalım
        WebElement amazonSonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        webElementResmi(amazonSonuc);
        bekle(2);
        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow(0);
        tumSayfaResmi();

    }
}
