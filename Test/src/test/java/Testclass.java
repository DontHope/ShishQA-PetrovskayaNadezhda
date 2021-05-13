
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;

    public class Testclass {
        private WebDriver driver;
        private String baseUrl = "https://sandbox.cardpay.com/MI/cardpayment2.html?orderXml=PE9SREVSIFdBTExFVF9JRD0nODI5OScgT1JERVJfTlVNQkVSPSc0NTgyMTEnIEFNT1VOVD0nMjkxLjg2JyBDVVJSRU5DWT0nRVVSJyAgRU1BSUw9J2N1c3RvbWVyQGV4YW1wbGUuY29tJz4KPEFERFJFU1MgQ09VTlRSWT0nVVNBJyBTVEFURT0nTlknIFpJUD0nMTAwMDEnIENJVFk9J05ZJyBTVFJFRVQ9JzY3NyBTVFJFRVQnIFBIT05FPSc4NzY5OTA5MCcgVFlQRT0nQklMTElORycvPgo8L09SREVSPg==&sha512=998150a2b27484b776a1628bfe7505a9cb430f276dfa35b14315c1c8f03381a90490f6608f0dcff789273e05926cd782e1bb941418a9673f43c47595aa7b8b0d";

        public Testclass() {
        }

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "D:\\ShishQA-PetrovskayaNadezhda\\Test\\src\\chromedriver.exe");
            this.driver = new ChromeDriver();
            this.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
            this.driver.manage().window().fullscreen();
        }

        @Test
        public void test1() throws IOException {
            this.driver.get(this.baseUrl);
            System.out.println("good1");
            Actions builder = new Actions(this.driver);
            System.out.println("good2");
            WebElement element = this.driver.findElement(By.xpath("//*[@id=\"cvc-hint-toggle\"]"));
            System.out.println("good3");
            builder.moveToElement(element).build().perform();
            System.out.println("good4");
            WebDriver augmentedDriver = (new Augmenter()).augment(this.driver);
            File scrFile = (File)((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("D:\\ShishQA-PetrovskayaNadezhda\\screenshot.png"));
        }

        @After
        public void tearDown() {
            this.driver.quit();
        }
    }

