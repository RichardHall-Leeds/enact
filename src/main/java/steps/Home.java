package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class Home {

    po.Home home = new po.Home();

    @And("I accept cookies")
    public void acceptCookies() {
            home.acceptCookies();
        }

}
