package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodlari static olmak zorundadir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her class'tan önce BeforeClass bir kez çalışır.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her class'tan sonra AfterClass bir kez çalışır.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her method'dan önce Before method'u bir kez çalışır.");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her method'dan sonra After(tearDown) methodu bir kez calisir.");
    }


    @Test
    public void test01() {
        System.out.println("Test01 methodu çalıştı");
    }

    @Test
    public void test02() {
        System.out.println("Test02 methodu çalıştı");
    }

    @Test
    public void test03() {
        System.out.println("Test03 methodu çalıştı");
    }
}
