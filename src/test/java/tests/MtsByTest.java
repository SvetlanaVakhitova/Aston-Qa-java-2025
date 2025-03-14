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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.PaymentFrame;

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

    @Test
    /**
     * Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из
     * предыдущей темы,
     * нажать кнопку «Продолжить» и в появившемся окне проверить корректность
     * отображения суммы
     * (в том числе на кнопке), номера телефона, а также надписей в незаполненных
     * полях для ввода
     * реквизитов карты, наличие иконок платёжных систем.
     */
    public void servicesFillTest() {
        homePage.open();

        // Заполняем и отправляем форму услуг связи
        homePage.fillServiceForm("297777777", "100", "test@test.com");
        homePage.submitServiceForm();

        // Проверяем появление фрейма оплаты
        Assert.assertTrue(homePage.isBepaidFrameDisplayed(),
                "Должен отображаться фрейм оплаты после отправки формы");

        // Создаем объект фрейма оплаты и проверяем все элементы
        PaymentFrame paymentFrame = new PaymentFrame(driver);

        WebElement yandexBtn = driver.findElement(By.id("yandex-button"));

        WebElement googleBtn = driver.findElement(By.id("gpay-button-online-api-id"));

        // Проверяем сумму и текст на кнопке оплаты
        Assert.assertEquals(paymentFrame.getCostSectionText(), "100.00 BYN");
        Assert.assertEquals(paymentFrame.getPayButtonText(), "Оплатить 100.00 BYN");

        // Проверяем отображение номера телефона
        Assert.assertEquals(paymentFrame.getPhoneNumberSectionText(),
                "Оплата: Услуги связи Номер:375297777777");

        // Проверяем надписи в полях ввода данных карты
        Assert.assertEquals(paymentFrame.getCardNumberLabel(), "Номер карты");
        Assert.assertEquals(paymentFrame.getCardExpiresLabel(), "Срок действия");
        Assert.assertEquals(paymentFrame.getCvcLabel(), "CVC");
        Assert.assertEquals(paymentFrame.getCardNameLabel(), "Имя держателя (как на карте)");

        // Проверяем наличие иконок платежных систем
        Assert.assertEquals(paymentFrame.getCardSystemImagesCount(), 3,
                "Должно быть 3 иконки платежных систем");
        Assert.assertEquals(paymentFrame.getMirSystemImagesCount(), 2,
                "Должно быть 2 иконки системы МИР");

        // Проверяем наличие кнопок альтернативных способов оплаты
        Assert.assertTrue(paymentFrame.isYandexPayButtonDisplayed(),
                "Кнопка YandexPay должна отображаться");
        Assert.assertTrue(paymentFrame.isGooglePayButtonDisplayed(),
                "Кнопка GooglePay должна отображаться");
    }
}
