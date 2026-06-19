package po;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Home extends Common {

    // Placeholders
    final String COOKIE_ACCEPT = "Accept All";
    final String PURCHASE_PRICE = "Purchase Price *";
    final String FIRST_TIME_BUYER = "Are you a first time buyer?";
    final String NAME = "Name *";
    final String EMAIL = "Email *";
    final String PHONE = "Phone *";
    final String POSTCODE = "Postcode *";
    final String GET_QUOTE_BUTTON = "Get Quote";

    // Ids
    final String PURCHASE_STAGE = "#purchaseDropdown";
    final String CONSENT ="#MKTConsent";




    public void acceptCookies() {
        Locator cookiesAcceptAllButton;

        cookiesAcceptAllButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(COOKIE_ACCEPT).setExact(true));
        cookiesAcceptAllButton.click();
    }

    public void completeForm(dto.Home content) {
        Locator purchasePrice = page.getByPlaceholder(PURCHASE_PRICE);
        purchasePrice.fill(content.getPurchasePrice());

        Locator purchaseStage = page.locator(PURCHASE_STAGE);
        purchaseStage.selectOption(content.getPurchaseStage());

        Locator firstTimeBuyer = page.getByRole(AriaRole.CHECKBOX,
                new Page.GetByRoleOptions().setName(FIRST_TIME_BUYER).setExact(true));
                    if(content.getFirstTimeBuyer().equals("Yes")) {
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

        // consent same variable name as in home.java and feature - is it ok?
        Locator consent = page.locator(CONSENT);
        if(content.getConsent().equals("N")) {
            consent.uncheck();
        }

        Locator getQuoteSubmit = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(GET_QUOTE_BUTTON).setExact(true));
        getQuoteSubmit.click();
    }
}
