public class PaymentPartnersSection extends BasePage {
    private static final String PARTNERS_BASE_XPATH = "//div[@class='pay__partners']/ul/li";

    private final Map<String, By> partnerLogos = Map.of(
        "Visa", By.xpath(PARTNERS_BASE_XPATH + "/img[1]"),
        "Verified By Visa", By.xpath(PARTNERS_BASE_XPATH + "[2]/img"),
        "MasterCard", By.xpath(PARTNERS_BASE_XPATH + "[3]/img"),
        "MasterCard Secure Code", By.xpath(PARTNERS_BASE_XPATH + "[4]/img"),
        "Белкарт", By.xpath(PARTNERS_BASE_XPATH + "[5]/img")
    );

    public PaymentPartnersSection(WebDriver driver) {
        super(driver);
    }

    public String getPartnerLogoAlt(String partnerName) {
        return driver.findElement(partnerLogos.get(partnerName)).getAttribute("alt");
    }
}
