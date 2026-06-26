package po;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Home extends Common {

    // UI Identifiers
    private static final String COOKIE_ACCEPT = "Accept All";
    private static final String PURCHASE_PRICE = "Purchase Price *";
    private static final String FIRST_TIME_BUYER = "Are you a first time buyer?";
    private static final String NAME = "Name *";
    private static final String EMAIL = "Email *";
    private static final String PHONE = "Phone *";
    private static final String POSTCODE = "Postcode *";
    private static final String GET_QUOTE_BUTTON = "Get Quote";

    // HTML Identifiers
    private static final String PURCHASE_STAGE = "#purchaseDropdown";
    private static final String CONSENT = "#MKTConsent";

    public void acceptCookies() {
        Locator cookiesAcceptAllButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(COOKIE_ACCEPT).setExact(true));
        cookiesAcceptAllButton.click();
    }

    public void requestInstantQuote(dto.Home content) {
        Locator purchasePrice = page.getByPlaceholder(PURCHASE_PRICE);
        purchasePrice.fill(content.getPurchasePrice());

        Locator purchaseStage = page.locator(PURCHASE_STAGE);
        purchaseStage.selectOption(content.getPurchaseStage());

        Locator firstTimeBuyer = page.getByRole(AriaRole.CHECKBOX,
                new Page.GetByRoleOptions().setName(FIRST_TIME_BUYER).setExact(true));
        if (content.getFirstTimeBuyer().equals("Yes")) {
            firstTimeBuyer.check();
        }

        Locator name = page.getByPlaceholder(NAME);
        name.fill(content.getName());

        Locator email = page.getByPlaceholder(EMAIL);
        email.fill(content.getEmail());

        Locator phone = page.getByPlaceholder(PHONE);
        phone.fill(content.getPhone());

        Locator postcode = page.getByPlaceholder(POSTCODE);
        postcode.fill(content.getPostcode());

        Locator consent = page.locator(CONSENT);
        if(content.getConsent().equals("No")) {
            consent.uncheck();
        }

//        Locator getQuote = page.getByRole(AriaRole.BUTTON,
//                new Page.GetByRoleOptions().setName(GET_QUOTE_BUTTON).setExact(true));
//        getQuote.click();
    }
}
