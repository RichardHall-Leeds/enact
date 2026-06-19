package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyStepdefs {
   @When("I complete the following")
    public void iCompleteTheFollowing() {
       System.out.println("i complete the following");
               throw new PendingException();
    }
}
