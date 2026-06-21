package steps;

import dto.DTOMap;
import io.cucumber.java.DataTableType;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class Quote {

    po.Quote quote  = new po.Quote();

    @DataTableType
    public dto.Quote decodeEnactForm(Map<String, String> row) {
        return dto.Quote.decode(new DTOMap(row));
    }

    @Then("I verify the Quote Summary section has correct values matching the user inputs")
    public void iVerifyTheYourQuoteScreenHasTheFollowingValues(List<dto.Quote> expectedValues) {
        quote.verifyQuoteSummary(expectedValues.get(0));
    }

    @And("I check these business important elements are displayed")
    //rename
    public void iCheckTheseBusinessImportantElementsAreDisplayed() {

    }

    @And("I verify the Quote Number is displayed and is {int} digits long")
    public void verifyQuoteNumberFormat(int digits) {
        quote.verifyQuoteNumber(digits);
    }

    @Then("I verify the system generated Total costs are correct on the Quote screen")
    public void verifyTotalCosts(List<dto.Quote> expectedValues) {
        quote.verifyTotalCosts(expectedValues.get(0));
    }
}
