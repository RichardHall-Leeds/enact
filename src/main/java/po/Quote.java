package po;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Quote extends Common {

    // TO CHECK can we use the same identifiers as in home.java or do we need to create new ones?
    // UI Identifiers

    // Quote Summary table tr definitions
    final int PURCHASE_PRICE = 0;
    final int TENURE = 1;
    final int QUOTE_NUMBER = 2;

    // HTML Identifiers
    final String PURCHASE_STAGE = "#purchaseDropdown";
    final String CONSENT ="#MKTConsent";

    public void completeForm(steps.Quote content) {
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
        if(content.getConsent().equals("No")) {
            consent.uncheck();
        }

        Locator getQuoteSubmit = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(GET_QUOTE_BUTTON).setExact(true));
        getQuoteSubmit.click();
    }
}
