package steps;

import dto.DTOMap;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Home {

    po.Home home = new po.Home();

    // TO CHECK:
    @DataTableType
    public dto.Home decodeEnactForm(Map<String, String> row) {
        return dto.Home.decode(new DTOMap(row));
    }

    @And("I accept cookies")
    public void acceptCookies() {
            home.acceptCookies();
        }

    @When("I complete the following fields")
    public void iCompleteTheFollowingFields(List<dto.Home> formList) {
         home.completeForm(formList.get(0));

    }
}
