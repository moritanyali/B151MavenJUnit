package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://amazon.com");
    }

    @Test
    public void titleTest() {
        //○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle)); //passed
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


    }

    @Test
    // ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    public void imageTest() {
        WebElement image = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(image.isDisplayed()); //passed
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung", Keys.ENTER);
    }

    @Test
    //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    public void searchBoxTest() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isDisplayed()); //passed
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nokia", Keys.ENTER);
    }

    @Test
    //○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
    public void wrongTitleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle)); //passed
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }
}
