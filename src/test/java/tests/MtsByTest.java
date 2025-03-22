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
import org.testng.annotations.Ignore;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.PaymentFrame;
import io.qameta.allure.*;

@Epic("MTS Payment System Tests")
@Feature("Online Payment Section")
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
    @Ignore("Не для отчёта")
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
    @Story("Payment Form Placeholders")
    @Description("Verifies placeholder text in payment form fields across different payment options")
    @Severity(SeverityLevel.NORMAL)
    public void onlinePaymentSectionVariantsTest() {
        openHomePage();
        
        Allure.step("Проверка формы Услуги связи", () -> {
            Assert.assertEquals(homePage.getServicesMobilePhonePlaceholder(),
                    "Номер телефона", "Mobile phone placeholder mismatch");
            Assert.assertEquals(homePage.getServicesSumPlaceholder(),
                    "Сумма", "Sum placeholder mismatch");
            Assert.assertEquals(homePage.getServicesEmailPlaceholder(),
                    "E-mail для отправки чека", "Email placeholder mismatch");
        });

        Allure.step("Проверка формы Домашний интернет", () -> {
            Assert.assertEquals(homePage.getInternetAccountPlaceholder(),
                    "Номер абонента", "Internet account placeholder mismatch");
            Assert.assertEquals(homePage.getInternetSumPlaceholder(),
                    "Сумма", "Internet sum placeholder mismatch");
            Assert.assertEquals(homePage.getInternetEmailPlaceholder(),
                    "E-mail для отправки чека", "Internet email placeholder mismatch");
        });

        Allure.step("Проверка формы Рассрочка", () -> {
            Assert.assertEquals(homePage.getInstallmentAccountPlaceholder(),
                    "Номер счета на 44", "Installment account placeholder mismatch");
            Assert.assertEquals(homePage.getInstallmentSumPlaceholder(),
                    "Сумма", "Installment sum placeholder mismatch");
            Assert.assertEquals(homePage.getInstallmentEmailPlaceholder(),
                    "E-mail для отправки чека", "Installment email placeholder mismatch");
        });

        Allure.step("Проверка формы Задолженность", () -> {
            Assert.assertEquals(homePage.getDebtAccountPlaceholder(),
                    "Номер счета на 2073", "Debt account placeholder mismatch");
            Assert.assertEquals(homePage.getDebtSumPlaceholder(),
                    "Сумма", "Debt sum placeholder mismatch");
            Assert.assertEquals(homePage.getDebtEmailPlaceholder(),
                    "E-mail для отправки чека", "Debt email placeholder mismatch");
        });
    }

    @Step("Opening MTS homepage")
    private void openHomePage() {
        homePage.open();
    }

    @Test
    @Ignore("Не для отчёта")
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
