package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @AfterMethod
    public void tearDownTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}

public class MtsByTest extends BaseTest {
    
    @BeforeMethod
    public void setUp() {
        super.setUpTest();
        driver.get("https://mts.by");
        Assert.assertEquals(driver.getTitle(), "МТС – мобильный оператор в Беларуси");
        // принимаем cookie
        driver.findElement(By.cssSelector("#cookie-agree")).click();
    }

    @Test
    public void verifyPaymentSectionTitleTest() {
        WebElement paySectionTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        Assert.assertEquals(paySectionTitle.getText(), "Онлайн пополнение\nбез комиссии");
    }

    @Test
    public void verifyPartnerLogosTest() {
        String[] expectedLogos = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        
        for (int i = 0; i < expectedLogos.length; i++) {
            WebElement logoElement = driver.findElement(
                By.xpath(String.format("//div[@class='pay__partners']/ul/li[%d]/img", (i == 0 ? 1 : i + 1)))
            );
            Assert.assertEquals(logoElement.getAttribute("alt"), expectedLogos[i], 
                String.format("Logo at position %d should be %s", i + 1, expectedLogos[i]));
        }
    }

    @Test
    public void verifyServiceDetailsLinkTest() {
        WebElement link = driver.findElement(By.xpath("//div[@class='pay__wrapper']/a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));
        Assert.assertEquals(link.getText(), "Подробнее о сервисе");
        
        link.click();
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    public void verifyPaymentFormTest() {
        WebElement phoneInput = driver.findElement(By.cssSelector("#connection-phone"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.cssSelector("#connection-sum"));
        sumInput.click();
        sumInput.sendKeys("100");

        WebElement paymentform = driver.findElement(By.cssSelector("#pay-connection"));
        paymentform.submit();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-app")));
    }
}