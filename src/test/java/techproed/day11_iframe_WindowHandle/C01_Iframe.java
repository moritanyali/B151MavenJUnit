package techproed.day11_iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {
       /*
        Bir HTML dokumaninin icine yerlestirilmis baska bir HTML dokumanina inline frame yani IFRAME denir.
    Bir sayfada iframe varsa iframe icindeki webelementi handle edebilmek icin swichTo() methoduyla
    ifram'e gecis yapmamiz gerekir. Eger gecis yapmaz isek nosuchelementexception aliriz.
        Alert'ten farki alert ciktiginda hicbirwebelementi locate edemeyiz. Iframe olsada locate ederiz fakat handle edemeyiz.
     */
    @Test
    public void iframe() {
        //➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //➢    Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String metin = driver.findElement(By.xpath("(//p)[1]")).getText();
        Assert.assertTrue(metin.contains("black border"));
        //➢    Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//iframe'e gectik, geçmezsek nosuchelementexception alırız.
        String appLists = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Applications lists", appLists);
        //➢    Son olarak Ana sayfadaki footer daki 'Povered By' yazisini varligini test edilip
        driver.switchTo().defaultContent(); //anasayfaya gider
        String poveredBy = driver.findElement(By.xpath("//*[text()='Povered By']")).getText();
        System.out.println(poveredBy);

        //➢    Son olarak sayfadaki iframe yazisinin gorunur oldugunu test edin
        driver.switchTo().defaultContent(); //iframe'den anasayfaya getirir bizi.
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());

                /*
            Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.
         */

                /*Nested iframe' lerde defaultContent ile refresh hangi iframe' de olursa olsun direk anasayfaya gecerken
        parentFrame sadece bir ust frame' e gecer
         */

    }
}
