import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestOne {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\ShishQA-PetrovskayaNadezhda\\Cardpay\\src\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://sandbox.cardpay.com/MI/cardpayment2.html?orderXml=PE9SREVSIFdBTExFVF9JRD0nODI5OScgT1JERVJfTlVNQkVSPSc0NTgyMTEnIEFNT1VOVD0nMjkxLjg2JyBDVVJSRU5DWT0nRVVSJyAgRU1BSUw9J2N1c3RvbWVyQGV4YW1wbGUuY29tJz4KPEFERFJFU1MgQ09VTlRSWT0nVVNBJyBTVEFURT0nTlknIFpJUD0nMTAwMDEnIENJVFk9J05ZJyBTVFJFRVQ9JzY3NyBTVFJFRVQnIFBIT05FPSc4NzY5OTA5MCcgVFlQRT0nQklMTElORycvPgo8L09SREVSPg==&sha512=998150a2b27484b776a1628bfe7505a9cb430f276dfa35b14315c1c8f03381a90490f6608f0dcff789273e05926cd782e1bb941418a9673f43c47595aa7b8b0d\n";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @Test
    public void testCase1() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("6");
        driver.findElement(By.id("card-number-field")).click();
        driver.findElement(By.xpath("//*[@id=\"card-number-field\"]/label")).click();
        assertEquals("Card number is not valid", driver.findElement(By.xpath("//div[@id='card-number-field']/div/label")).getText());
    }

    @Test
    public void testCase2() {
        driver.get(baseUrl);
        String Test5 = driver.findElement(By.xpath("//*[@id=\"order-number\"]")).getText();
        String Test6 = driver.findElement(By.xpath("//*[@id=\"total-amount-cnt\"]")).getText();
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0093");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("SVSD EFE");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("06");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2024");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("546");
        driver.findElement(By.id("payment-data-fields")).click();
        driver.findElement(By.id("action-submit")).click();
        assertEquals(Test5, driver.findElement(By.xpath("//*[@id=\"payment-item-ordernumber\"]/div[2]")).getText());
        assertEquals( "EUR   291.86", driver.findElement(By.xpath("//div[@id='payment-item-total']/div[2]")).getText());
    }


    @Test
    public void testCase3() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0002");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("55454 FHHTH");
        driver.findElement(By.id("card-number-field")).click();
        driver.findElement(By.xpath("//*[@id=\"card-holder-field\"]/div/label")).click();
        assertEquals("Cardholder name is not valid", driver.findElement(By.xpath("//div[@id='card-holder-field']/div/label")).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
