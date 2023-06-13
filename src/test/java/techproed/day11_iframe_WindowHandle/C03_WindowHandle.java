package techproed.day11_iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya dnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degiskene handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
         */
    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproHandle = driver.getWindowHandle();
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String title = driver.getTitle();
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps", title);

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.WINDOW);//yeni bir pencereye driver'i taşır.
                //WindowType.TAB --> Yeni bir sekme açar.
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();
        // Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproHandle);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandle);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
        bekle(2);
    }

    @Test
    public void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproHandle = driver.getWindowHandle();
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String title = driver.getTitle();
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps", title);

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.TAB);//yeni bir pencereye driver'i taşır.
        //WindowType.TAB --> Yeni bir sekme açar.
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();
        // Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproHandle);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandle);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
        bekle(2);
    }

    /*
    öev
    Yeni bir class olusturun: WindowHandle
Amazon anasayfa adresine gidin.
Sayfa’nin window handle degerini String bir degiskene atayin
Sayfa title’nin “Amazon” icerdigini test edin
Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
Sayfa title’nin “Walmart” icerdigini test edin
Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */
}
