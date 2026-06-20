package po;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Quote extends Common {

    // User-facing row labels (these are what a user sees in the left column)
    // to do: tie other files lables up with this - ensure a match┃
    final String PURCHASE_PRICE = "Purchase Price";
    final String TENURE         = "Tenure";
    final String QUOTE_NUMBER   = "Quote Number";

    // HTML Identifiers

    public void verifyForm(dto.Quote content) {

        Locator purchasePriceRow = page.getByRole(AriaRole.ROW,
        new Page.GetByRoleOptions().setName(PURCHASE_PRICE));
        assertThat(purchasePriceRow).containsText(content.getPurchasePriceQuote());

        Locator tenureRow = page.getByRole(AriaRole.ROW,
        new Page.GetByRoleOptions().setName(TENURE));
        assertThat(tenureRow).containsText(content.getTenure());

//        Locator quoteNumberRow = page.getByRole(AriaRole.ROW,
//        new Page.GetByRoleOptions().setName(QUOTE_NUMBER));
//        assertThat(quoteNumberRow).containsText(content.getQuoteNumber());
    }



}
