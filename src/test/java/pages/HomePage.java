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

    private final By homeInternetTabLocator = By.cssSelector("button[data-type='internet']");
    private final By installmentTabLocator = By.cssSelector("button[data-type='installment']");
    private final By debtTabLocator = By.cssSelector("button[data-type='debt']");

    // локаторы для формы услуги связи
    private final By ServicesMobilePhoneInputLocator = By.xpath("//form[@id='pay-connection']/*/input[@class='phone']");
    private final By ServicesSumLocator = By.xpath("//form[@id='pay-connection']/*/input[@class='total_rub']");
    private final By ServicesEmailLocator = By.xpath("//form[@id='pay-connection']/*/input[@class='total_rub']");

    // локаторы для формы Домашний интернет
    private final By InternetMobilePhoneInputLocator = By.xpath("//form[@id='pay-internet']/*/input[@class='phone']");
    private final By InternetSumLocator = By.xpath("//form[@id='pay-internet']/*/input[@class='total_rub']");
    private final By InternetEmailLocator = By.xpath("//form[@id='pay-internet']/*/input[@class='email']");

    // локаторы для формы рассрочка
    private final By InstallmentNumberInputLocator = By
            .xpath("//form[@id='pay-instalment']/*/input[@id='score-instalment']");
    private final By InstallmentSumLocator = By.xpath("//form[@id='pay-instalment']/*/input[@class='total_rub']");
    private final By InstallmentEmailLocator = By.xpath("//form[@id='pay-instalment']/*/input[@class='email']");

    // локаторы для формы задолженность
    private final By DebtScoreInputLocator = By.xpath("//form[@id='pay-connection']/*/input[@class='phone']");
    private final By DebtSumLocator = By.xpath("//form[@id='pay-connection']/*/input[@class='total_rub']");
    private final By DebtEmailLocator = By.xpath("//form[@id='pay-connection']/*/input[@class='total_rub']");

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

    /// ----------

    public String getInternetMobilePhonePlaceholder() {
        waitForElementVisible(InternetMobilePhoneInputLocator);
        return driver.findElement(InternetMobilePhoneInputLocator).getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() {
        waitForElementVisible(InternetSumLocator);
        return driver.findElement(InternetSumLocator).getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() {
        waitForElementVisible(InternetEmailLocator);
        return driver.findElement(InternetEmailLocator).getAttribute("placeholder");
    }

    // ---- рассрочка

    public String getInstallmentNumberPlaceholder() {
        waitForElementVisible(InstallmentNumberInputLocator);
        return driver.findElement(InstallmentNumberInputLocator).getAttribute("placeholder");
    }

    public String getInstallmentSumPlaceholder() {
        waitForElementVisible(InstallmentSumLocator);
        return driver.findElement(InstallmentSumLocator).getAttribute("placeholder");
    }

    public String getInstallmentEmailPlaceholder() {
        waitForElementVisible(InstallmentEmailLocator);
        return driver.findElement(InstallmentEmailLocator).getAttribute("placeholder");
    }

    // -- задолженность

    public String getDebtScorePlaceholder() {
        waitForElementVisible(DebtScoreInputLocator);
        return driver.findElement(DebtScoreInputLocator).getAttribute("placeholder");
    }

    public String getDebtSumPlaceholder() {
        waitForElementVisible(DebtSumLocator);
        return driver.findElement(DebtSumLocator).getAttribute("placeholder");
    }

    public String getDebtEmailPlaceholder() {
        waitForElementVisible(DebtEmailLocator);
        return driver.findElement(DebtEmailLocator).getAttribute("placeholder");
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://mts.by");
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

    public void fillPaymentForm(String phoneNumber, String amount) {
        WebElement phoneInput = driver.findElement(phoneInputLocator);
        phoneInput.click();
        phoneInput.sendKeys(phoneNumber);

        WebElement sumInput = driver.findElement(sumInputLocator);
        sumInput.click();
        sumInput.sendKeys(amount);
    }

    public void submitPaymentForm() {
        driver.findElement(payFormLocator).submit();
        waitForElementVisible(bepaidFrameLocator);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void switchToHomeInternetTab() {
        waitForElementClickable(homeInternetTabLocator);
        driver.findElement(homeInternetTabLocator).click();
    }

    public void switchToInstallmentTab() {
        waitForElementClickable(installmentTabLocator);
        driver.findElement(installmentTabLocator).click();
    }

    public void switchToDebtTab() {
        waitForElementClickable(debtTabLocator);
        driver.findElement(debtTabLocator).click();
    }

    public String getInternetAccountPlaceholder() {
        waitForElementVisible(internetAccountInputLocator);
        return driver.findElement(internetAccountInputLocator).getAttribute("placeholder");
    }

    public String getInstallmentAccountPlaceholder() {
        waitForElementVisible(installmentAccountInputLocator);
        return driver.findElement(installmentAccountInputLocator).getAttribute("placeholder");
    }

    public String getDebtAccountPlaceholder() {
        waitForElementVisible(debtAccountInputLocator);
        return driver.findElement(debtAccountInputLocator).getAttribute("placeholder");
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
}