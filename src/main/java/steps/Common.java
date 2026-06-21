package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Common {

    po.Common common = new po.Common();

    @Given("I open a browser")
    public void openABrowser() {
        common.open();
    }

    @Given("I navigate to {word}")
    public void navigateTo(String url) {
        common.navigate(url);
    }
}
