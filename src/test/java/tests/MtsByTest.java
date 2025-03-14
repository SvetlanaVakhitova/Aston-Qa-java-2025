package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class MtsByTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void onlinePaymentSectionTest() {
        // Open homepage and verify title
        homePage.open();
        Assert.assertEquals(homePage.getTitle(), "МТС – мобильный оператор в Беларуси");

        // Verify payment section title
        Assert.assertEquals(homePage.getPaySectionTitle(), "Онлайн пополнение\nбез комиссии");

        // Verify partner logos
        Assert.assertEquals(homePage.getPartnerLogoAlt("visa"), "Visa");
        Assert.assertEquals(homePage.getPartnerLogoAlt("verified-by-visa"), "Verified By Visa");
        Assert.assertEquals(homePage.getPartnerLogoAlt("mastercard"), "MasterCard");
        Assert.assertEquals(homePage.getPartnerLogoAlt("mastercard-secure"), "MasterCard Secure Code");
        Assert.assertEquals(homePage.getPartnerLogoAlt("belcard"), "Белкарт");

        // Verify and click service details link
        Assert.assertEquals(homePage.getServiceDetailsLinkText(), "Подробнее о сервисе");
        homePage.clickServiceDetailsLink();

        // Navigate back and test payment form
        homePage.navigateBack();
        homePage.fillPaymentForm("297777777", "100");
        homePage.submitPaymentForm();

    }

    @Test
    /**
     * 
     * Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги
     * связи, домашний интернет, рассрочка, задолженность;
     */
    public void onlinePaymentSectionVariantsTest() {
        
        homePage.open();

        Assert.assertEquals(homePage.getServicesMobilePhonePlaceholder(),
        "Номер телефона");

        Assert.assertEquals(homePage.getServicesSumPlaceholder(),
        "Сумма");

        Assert.assertEquals(homePage.getServicesEmailPlaceholder(),
        "E-mail для отправки чека");


        homePage.switchToHomeInternetTab();


        Assert.assertEquals(homePage.getInternetAccountPlaceholder(),
                "Номер абонента");

        Assert.assertEquals(homePage.getInternetSumPlaceholder(),
                "Сумма");     

        Assert.assertEquals(homePage.getInternetEmailPlaceholder(),
                "E-mail для отправки чека");     

        // Check Installment form
        homePage.switchToInstallmentTab();
        Assert.assertEquals(homePage.getInstallmentAccountPlaceholder(),
                "номер счета на 44");

        Assert.assertEquals(homePage.getInstallmentSumPlaceholder(),
                "Сумма");

         Assert.assertEquals(homePage.getInstallmentEmailPlaceholder(),
                "E-mail для отправки чека");        

        // Check Debt form
        homePage.switchToDebtTab();
        Assert.assertEquals(homePage.getDebtAccountPlaceholder(),
                "Номер счета на 2073");
        
                Assert.assertEquals(homePage.getDebtSumPlaceholder(),
                "Сумма");

                Assert.assertEquals(homePage.getDebtEmailPlaceholder(),
                "E-mail для отправки чека");
    }
}
