public class PaymentFrame extends BasePage {
    private final By costSectionLocator = By
            .xpath("//div[@class='app-wrapper__content']/div/*/*/*/app-card-page/div/div/div");
    private final By payButtonLocator = By
            .xpath("//div[@class='app-wrapper__content']/div/*/*/*/app-card-page/div/div/button");
    private final By phoneNumberSectionLocator = By.xpath(
            "//div[@class='app-wrapper__content']/*/*/*/div[@class='payment-page__container']/*/div[@class='pay-description__text']");
    private final By cardNumberLabelLocator = By.xpath("//input[@id='cc-number']/following::label[1]");
    private final By cardSystemImagesLocator = By.xpath(
            "//div[@class='cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted']/img");
    private final By mirSystemImagesLocator = By
            .xpath("//div[@class='cards-brands cards-brands_random ng-tns-c61-0 ng-star-inserted']/img");
    private final By cardExpiresLabelLocator = By
            .xpath("//div[@class='expires-input ng-tns-c61-0 ng-star-inserted']/*/*/*/*/label");
    private final By cvcLabelLocator = By
            .xpath("//div[@class='cvc-input ng-tns-c61-0 ng-star-inserted']/*/*/*/*/label");
    private final By cardNameLabelLocator = By
            .xpath("//div[@class='row ng-tns-c61-0 ng-star-inserted'][3]/*/*/*/*/label");
    private final By yandexPayButtonLocator = By.id("yandex-button");
    private final By googlePayButtonLocator = By.id("gpay-button-online-api-id");

    public PaymentFrame(WebDriver driver) {
        super(driver);
    }

    public String getCostSectionText() {
        waitForElementVisible(costSectionLocator);
        return driver.findElement(costSectionLocator).getText();
    }

    public String getPayButtonText() {
        return driver.findElement(payButtonLocator).getText();
    }

    public String getPhoneNumberSectionText() {
        return driver.findElement(phoneNumberSectionLocator).getText();
    }

    public String getCardNumberLabel() {
        return driver.findElement(cardNumberLabelLocator).getText();
    }

    public int getCardSystemImagesCount() {
        return driver.findElements(cardSystemImagesLocator).size();
    }

    public int getMirSystemImagesCount() {
        return driver.findElements(mirSystemImagesLocator).size();
    }

    public String getCardExpiresLabel() {
        return driver.findElement(cardExpiresLabelLocator).getText();
    }

    public String getCvcLabel() {
        return driver.findElement(cvcLabelLocator).getText();
    }

    public String getCardNameLabel() {
        return driver.findElement(cardNameLabelLocator).getText();
    }

    public boolean isYandexPayButtonDisplayed() {
        waitForElementVisible(yandexPayButtonLocator);
        return driver.findElement(yandexPayButtonLocator).isDisplayed();
    }

    public boolean isGooglePayButtonDisplayed() {
        waitForElementVisible(googlePayButtonLocator);
        return driver.findElement(googlePayButtonLocator).isDisplayed();
    }
}