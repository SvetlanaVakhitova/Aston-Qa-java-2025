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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MtsByTest {

    @Test
    public void onlinePaymentSectionTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://mts.by");

        Assert.assertEquals(driver.getTitle(), "МТС – мобильный оператор в Беларуси");

          //сначала убираем модальное окно про cookie
          driver.findElement(By.cssSelector("#cookie-agree")).click();

        WebElement paySectionTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));

        // проверка названия секции
        Assert.assertEquals(paySectionTitle.getText(), "Онлайн пополнение\nбез комиссии");

        // проверка наличия логотипов поартнёров (картинки)
        WebElement visaElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li/img[1]"));

        Assert.assertEquals(visaElement.getAttribute("alt"), "Visa");

        WebElement verifiedByVisaElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[2]/img"));

        Assert.assertEquals(verifiedByVisaElement.getAttribute("alt"), "Verified By Visa");

        WebElement masterCardElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[3]/img"));

        Assert.assertEquals(masterCardElement.getAttribute("alt"), "MasterCard");

        WebElement masterCardSecureCodeElement = driver
                .findElement(By.xpath("//div[@class='pay__partners']/ul/li[4]/img"));

        Assert.assertEquals(masterCardSecureCodeElement.getAttribute("alt"), "MasterCard Secure Code");

        WebElement belCardElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[5]/img"));

        Assert.assertEquals(belCardElement.getAttribute("alt"), "Белкарт");

        // проверка ссылки "Подробнее о сервисе"
      

        WebElement link = driver.findElement(By.xpath(
                "//div[@class='pay__wrapper']/a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));

        Assert.assertEquals(link.getText(), "Подробнее о сервисе");

        link.click();

        // ждём пока в строке браузера не появится poryadok-oplaty... и так далее
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));

        /**
         * Заполнить поля и проверить работу кнопки «Продолжить»
         * (проверяем только вариант «Услуги связи», номер для теста 297777777)
         *  
         * */ 
        // возвращаемся на главную страницу
        driver.navigate().back();

        // заполняем форму платежа
        WebElement phoneInput = driver.findElement(By.cssSelector("#connection-phone"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.cssSelector("#connection-sum"));
        sumInput.click();
        sumInput.sendKeys("100");

        WebElement paymentform = driver.findElement(By.cssSelector("#pay-connection"));

        // так как кнопка "продолжить" на самом деле делает submit формы платежа, то  делаем этот submit
        paymentform.submit();

        // ждём пока появится модальное окно с вводом данных платёжной карты, и его
        // появляение считаем пройденным тестом кнопки "Оплатить"
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-app")));

        driver.quit();
    }

}