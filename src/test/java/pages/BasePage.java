public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 5;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    protected void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void handleCookiePopup() {
        try {
            WebElement cookieAgree = wait
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cookie-agree")));
            cookieAgree.click();
        } catch (TimeoutException ignored) {
            // Cookie popup not present
        }
    }
}