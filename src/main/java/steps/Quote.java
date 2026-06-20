package steps;

import dto.DTOMap;
import dto.Home;
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

    @Then("I verify the Your Quote screen has the following values")
    public void iVerifyTheYourQuoteScreenHasTheFollowingValues(List<dto.Quote> formList) {
        quote.verifyForm(formList.get(0));
    }

    @And("I check these business important elements are displayed")
    public void iCheckTheseBusinessImportantElementsAreDisplayed() {

    }
}
