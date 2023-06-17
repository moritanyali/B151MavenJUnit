package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        Actions actions = new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT). //-->Arama kutusnda shift tuşuna bastık
                sendKeys("selenium").
                keyUp(Keys.SHIFT). //--> SHIFT TUŞUNU serbest bıraktık.
                sendKeys("-java", Keys.ENTER).//-->bu kısmı shift'i serbest bıraktığımız için küçük yazdı
                perform();
        bekle(3);

    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys(Keys.SHIFT, "selenium",Keys.SHIFT, "-java", Keys.ENTER);
        bekle(3);
           /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */

    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Selenium", Keys.ENTER);
        // Sayfayı bekleyin
        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        Actions actions = new Actions(driver);
        WebElement yazi = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        actions.doubleClick(yazi).keyDown(Keys.CONTROL).keyDown("x").keyUp(Keys.CONTROL).keyUp("x").perform();
        bekle(2);

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().back();
        searchBox.sendKeys(Keys.CONTROL, "v", Keys.ENTER);
        bekle(3);

        /*
        Ödev
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    2- Hover over  Me First" kutusunun ustune gelin
    3- Link 1" e tiklayin
    4- Popup mesajini yazdirin
    5- Popup'i tamam diyerek kapatin
    6- “Click and hold" kutusuna basili tutun
    7-“Click and hold" kutusunda cikan yaziyi yazdirin  8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
         */
    }
}
