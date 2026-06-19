package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Common {

    po.Common common = new po.Common();

    @Given("I open a browser")
    public void iOpenABrowser() {
        common.open();

    }

    @And("I navigate to {word}")
    public void iNavigateToTheLocalForm(String url) {
        common.navigate(url);


    }
}
