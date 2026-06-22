package steps;

import dto.DTOMap;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class Quote {

    po.Quote quote = new po.Quote();

    @DataTableType
    public dto.Quote decodeEnactForm(Map<String, String> row) {
        return dto.Quote.decode(new DTOMap(row));
    }

    @Then("the system-generated Total costs are correct on the Quote screen:")
    public void verifyTotalCosts(List<dto.Quote> expectedValues) {
        quote.verifyTotalCosts(expectedValues.get(0));
    }

    @Then("the Quote Summary section matches the user inputs:")
    public void verifyQuoteSummary(List<dto.Quote> expectedValues) {
        quote.verifyQuoteSummary(expectedValues.get(0));
    }

    @Then("the Quote Number is displayed and is {int} digits long")
    public void verifyQuoteNumber(int digits) {
        quote.verifyQuoteNumber(digits);
    }

    @Then("the Instruct Now link is displayed")
    public void verifyInstructNowShows() {
        quote.verifyInstructNowShows();
    }
}
