package po;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Quote extends Common {

    // User-facing row labels (these are what a user sees in the left column)
    // to do: tie other files lables up with this - ensure a match
    final String TENURE = "Tenure";

    // HTML ID Identifiers
    final String PURCHASE_PRICE = "[data-enact-result-field='PurchasePrice']";
    final String TOTAL_CONVEYANCE_FEE = "[data-enact-result-field='TotalFeeIncVAT']";
    final String TOTAL_FEE_AND_SEARCH_PACK = "[data-enact-result-field='TotalFeeAndSearchPackIncVAT']";
    final String ESTIMATED_TOTAL = "[data-enact-contains-result-field='Purchase-EstimatedTotalIncVAT'] [data-enact-result-field='EstimatedTotalIncVAT']"; ;
    final String QUOTE_NUMBER = "[data-enact-result-field='QuoteID']";

    public void verifyQuoteSummary(dto.Quote content) {
        Locator purchasePriceRow =  page.locator(PURCHASE_PRICE);
        assertThat(purchasePriceRow).hasText(content.getPurchasePriceQuote());

        Locator tenureRow = page.getByRole(AriaRole.ROW,
        new Page.GetByRoleOptions().setName(TENURE));
        assertThat(tenureRow).containsText(content.getTenure());

    }

    public void verifyTotalCosts(dto.Quote content) {
        Locator totalConveyancingFees = page.locator(TOTAL_CONVEYANCE_FEE);
        assertThat(totalConveyancingFees).hasText(content.getTotalConveyancingFees());

        Locator totalFeeSearchPack = page.locator(TOTAL_FEE_AND_SEARCH_PACK);
        assertThat(totalFeeSearchPack).hasText(content.getTotalFeeAndSearchPack());

        Locator estimatedTotal = page.locator(ESTIMATED_TOTAL);
        assertThat(estimatedTotal).hasText(content.getEstimatedTotal());

    }

    public void verifyQuoteNumber(int digits) {
        Locator quoteNumberValue = page.locator(QUOTE_NUMBER);
        assertThat(quoteNumberValue).hasText(
                Pattern.compile("^\\d{" + digits + "}$"));
    }


}
