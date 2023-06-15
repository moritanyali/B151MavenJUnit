package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {

//    Aşağıdaki bilgileri kullanarak authentication yapınız:
//    Url: https://the-internet.herokuapp.com/basic_auth
//    Username: admin
//    Password: admin
//    Başarılı girişi doğrulayın.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);
//Congratulations! yazısının çıktığını doğrulayın
        WebElement congText = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(congText.getText().contains("Congratulations!"));

        //Elemental Selenium yazısına tıklayalım
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[@target]"));
        elementalSelenium.click();
        switchToWindow(1);
        bekle(3);
        //Başlığın Elemental Selenium olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.equals("Elemental Selenium")); //or assertNotEquals

        //DDM'den java seçelim
        WebElement ddm = driver.findElement(By.xpath("//*[@class='dropdown-language']"));
        Select select = new Select(ddm);
        select.selectByValue("Java");
        bekle(2);
        //selectVisibleText(ddm, "Java"); //Method ile
    }
}
