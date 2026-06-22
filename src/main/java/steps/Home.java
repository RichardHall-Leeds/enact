package steps;

import dto.DTOMap;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Home {

    po.Home home = new po.Home();

    @DataTableType
    public dto.Home decodeEnactForm(Map<String, String> row) {
        return dto.Home.decode(new DTOMap(row));
    }

    @Given("I accept cookies")
    public void acceptCookies() {
        home.acceptCookies();
    }

    @When("I submit an Instant Quote with the following details:")
    public void requestInstantQuote(List<dto.Home> expectedValues) {
        home.requestInstantQuote(expectedValues.get(0));
        }
}

