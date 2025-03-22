package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;

public class HomePage extends BasePage {

    private final By paySectionTitleLocator = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By phoneInputLocator = By.cssSelector("#connection-phone");
    private final By sumInputLocator = By.cssSelector("#connection-sum");
    private final By payFormLocator = By.cssSelector("#pay-connection");
    private final By bepaidFrameLocator = By.className("bepaid-app");
    private final By serviceDetailsLinkLocator = By
            .xpath("//div[@class='pay__wrapper']/a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']");

    private final By submitButtonLocator = By.xpath("//button[@type='submit']");
    private final By mobilePhoneInputLocator = By.xpath("//input[@placeholder='Номер телефона']");

    // Tab locators
    private final By selectHeaderLocator = By.className("select__header");
    private final By homeInternetTabLocator = By.xpath("//li[contains(@class, 'select__item')][.//p[text()='Домашний интернет']]");
    private final By installmentTabLocator = By.xpath("//li[contains(@class, 'select__item')][.//p[text()='Рассрочка']]");
    private final By debtTabLocator = By.xpath("//li[contains(@class, 'select__item')][.//p[text()='Задолженность']]");

    // Services form locators
    private final By ServicesMobilePhoneInputLocator = By.xpath("//form[@id='pay-connection']/*/input[@class='phone']");
    private final By ServicesSumLocator = By.xpath("//form[@id='pay-connection']/*/input[@class='total_rub']");
    private final By ServicesEmailLocator = By.xpath("//form[@id='pay-connection']/*/input[@class='email']");

    // Internet form locators
    private final By InternetMobilePhoneInputLocator = By.xpath("//form[@id='pay-internet']/*/input[@class='phone']");
    private final By InternetSumLocator = By.xpath("//form[@id='pay-internet']/*/input[@class='total_rub']");
    private final By InternetEmailLocator = By.xpath("//form[@id='pay-internet']/*/input[@class='email']");

    // Installment form locators
    private final By InstallmentNumberInputLocator = By.xpath("//form[@id='pay-instalment']/*/input[@id='score-instalment']");
    private final By InstallmentSumLocator = By.xpath("//form[@id='pay-instalment']/*/input[@class='total_rub']");
    private final By InstallmentEmailLocator = By.xpath("//form[@id='pay-instalment']/*/input[@class='email']");

    // Debt form locators (corrected to use pay-arrears instead of pay-debt)
    private final By DebtScoreInputLocator = By.xpath("//form[@id='pay-arrears']/*/input[@id='score-arrears']");
    private final By DebtSumLocator = By.xpath("//form[@id='pay-arrears']/*/input[@class='total_rub']");
    private final By DebtEmailLocator = By.xpath("//form[@id='pay-arrears']/*/input[@class='email']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.mts.by");
        handleCookiePopup();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPaySectionTitle() {
        waitForElementVisible(paySectionTitleLocator);
        return driver.findElement(paySectionTitleLocator).getText();
    }

    public String getServiceDetailsLinkText() {
        waitForElementVisible(serviceDetailsLinkLocator);
        return driver.findElement(serviceDetailsLinkLocator).getText();
    }

    public void clickServiceDetailsLink() {
        waitForElementClickable(serviceDetailsLinkLocator);
        driver.findElement(serviceDetailsLinkLocator).click();
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    // Tab switching methods
    public void switchToHomeInternetTab() {
        waitForElementClickable(selectHeaderLocator);
        driver.findElement(selectHeaderLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select__list")));
        WebElement element = driver.findElement(homeInternetTabLocator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(InternetMobilePhoneInputLocator));
    }

    public void switchToInstallmentTab() {
        waitForElementClickable(selectHeaderLocator);
        driver.findElement(selectHeaderLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select__list")));
        WebElement element = driver.findElement(installmentTabLocator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(InstallmentNumberInputLocator));
    }

    public void switchToDebtTab() {
        waitForElementClickable(selectHeaderLocator);
        driver.findElement(selectHeaderLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select__list")));
        WebElement element = driver.findElement(debtTabLocator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DebtScoreInputLocator));
    }

    // Restored methods needed by other tests
    public void fillPaymentForm(String phone, String sum) {
        WebElement phoneInput = driver.findElement(mobilePhoneInputLocator);
        WebElement sumInput = driver.findElement(sumInputLocator);
        
        phoneInput.sendKeys(phone);
        sumInput.sendKeys(sum);
    }

    public void submitPaymentForm() {
        driver.findElement(submitButtonLocator).click();
        waitForElementVisible(bepaidFrameLocator);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    // Services form methods
    public String getServicesMobilePhonePlaceholder() {
        waitForElementVisible(ServicesMobilePhoneInputLocator);
        return driver.findElement(ServicesMobilePhoneInputLocator).getAttribute("placeholder");
    }

    public String getServicesSumPlaceholder() {
        waitForElementVisible(ServicesSumLocator);
        return driver.findElement(ServicesSumLocator).getAttribute("placeholder");
    }

    public String getServicesEmailPlaceholder() {
        waitForElementVisible(ServicesEmailLocator);
        return driver.findElement(ServicesEmailLocator).getAttribute("placeholder");
    }

    // Internet form methods
    public String getInternetAccountPlaceholder() {
        switchToHomeInternetTab();
        return driver.findElement(InternetMobilePhoneInputLocator).getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() {
        return driver.findElement(InternetSumLocator).getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() {
        return driver.findElement(InternetEmailLocator).getAttribute("placeholder");
    }

    // Installment form methods
    public String getInstallmentAccountPlaceholder() {
        switchToInstallmentTab();
        return driver.findElement(InstallmentNumberInputLocator).getAttribute("placeholder");
    }

    public String getInstallmentSumPlaceholder() {
        return driver.findElement(InstallmentSumLocator).getAttribute("placeholder");
    }

    public String getInstallmentEmailPlaceholder() {
        return driver.findElement(InstallmentEmailLocator).getAttribute("placeholder");
    }

    // Debt form methods
    public String getDebtAccountPlaceholder() {
        switchToDebtTab();
        return driver.findElement(DebtScoreInputLocator).getAttribute("placeholder");
    }

    public String getDebtSumPlaceholder() {
        return driver.findElement(DebtSumLocator).getAttribute("placeholder");
    }

    public String getDebtEmailPlaceholder() {
        return driver.findElement(DebtEmailLocator).getAttribute("placeholder");
    }

    public void fillServiceForm(String phoneNumber, String sum, String email) {
        WebElement phoneInput = driver.findElement(ServicesMobilePhoneInputLocator);
        phoneInput.click();
        phoneInput.sendKeys(phoneNumber);

        WebElement sumInput = driver.findElement(ServicesSumLocator);
        sumInput.click();
        sumInput.sendKeys(sum);

        WebElement emailInput = driver.findElement(ServicesEmailLocator);
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void submitServiceForm() {
        driver.findElement(payFormLocator).submit();
        waitForElementVisible(bepaidFrameLocator);
    }

    public boolean isBepaidFrameDisplayed() {
        try {
            waitForElementVisible(bepaidFrameLocator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getPartnerLogoAlt(String partner) {
        WebElement logo = driver.findElement(By.xpath("//div[@class='pay__partners']//img[contains(@src,'" + partner + "')]"));
        return logo.getAttribute("alt");
    }
}