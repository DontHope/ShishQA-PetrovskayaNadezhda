import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestTwo {
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
        driver.findElement(By.id("input-card-number")).sendKeys("5555555555554444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("pet nad");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("07");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2024");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("666");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
        driver.findElement(By.id("payment-status")).click();
        assertEquals("Decline", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());
    }

    @Test
    public void  testCase2()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555 5555 5555 4444");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("pet nad");
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2029");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("666");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.id("success")).click();
        driver.findElement(By.id("payment-status")).click();
        driver.findElement(By.id("payment-item-status")).click();
        assertEquals("Payment status", driver.findElement(By.xpath("//div[@id='payment-item-status']/div/span")).getText());
    }

    @Test
    public void  testCase13()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000000000000044");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("pet nad");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("666");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.xpath("//*[@id=\"success\"]")).submit();
        driver.findElement(By.id("payment-status")).click();

        assertEquals("CONFIRMED", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }


    @Test
    public void  testCase4()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0036");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("pet nad");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("666");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.id("payment-status")).click();

        assertEquals("Confirmed", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }

    @Test
    public void  testCase5()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0093");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("pet nad");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("666");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.id("payment-status")).click();
        assertEquals("Confirmed", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }
    @Test
    public void  testCase6()  {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0069");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("pet nad");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("666");
        driver.findElement(By.id("action-submit")).click();
        driver.findElement(By.id("payment-status")).click();
        assertEquals("Confirmed", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }

    @Test
    public void  testCase7() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000 0000 0000 0085");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("pet nad");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("02");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2025");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("666");
        driver.findElement(By.id("action-submit")).click();
              assertEquals("Confirmed", driver.findElement(By.xpath("//[@id=\"payment-item-status\"]/div[2]")).getText());

    }

    @Test
    public void  testCase8() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000000000000077");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("pet nad");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("666");
        driver.findElement(By.id("action-submit")).click();
             assertEquals("Confirmed", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }

    @Test
    public void  testCase9() {
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("5555555555554477");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("pet nad");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("666");
        driver.findElement(By.id("action-submit")).click();
         assertEquals("Decline", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());

    }

    @Test
    public void  testCase10(){
        driver.get(baseUrl);
        driver.findElement(By.id("input-card-number")).click();
        driver.findElement(By.id("input-card-number")).clear();
        driver.findElement(By.id("input-card-number")).sendKeys("4000000000000051");
        driver.findElement(By.id("input-card-holder")).click();
        driver.findElement(By.id("input-card-holder")).clear();
        driver.findElement(By.id("input-card-holder")).sendKeys("pet nad");
        driver.findElement(By.id("payment-form")).submit();
        driver.findElement(By.id("card-expires-month")).click();
        new Select(driver.findElement(By.id("card-expires-month"))).selectByVisibleText("04");
        driver.findElement(By.id("card-expires-month")).click();
        driver.findElement(By.id("card-expires-year")).click();
        new Select(driver.findElement(By.id("card-expires-year"))).selectByVisibleText("2026");
        driver.findElement(By.id("card-expires-year")).click();
        driver.findElement(By.id("input-card-cvc")).click();
        driver.findElement(By.id("input-card-cvc")).clear();
        driver.findElement(By.id("input-card-cvc")).sendKeys("666");
        driver.findElement(By.id("action-submit")).click();
         assertEquals("CONFIRMED", driver.findElement(By.xpath("//*[@id=\"payment-item-status\"]/div[2]")).getText());
    }
}


