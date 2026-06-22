package steps;

import io.cucumber.java.After;

public class Hooks {

    po.Common common = new po.Common();

    @After
    public void tearDown() {
        common.close();
    }
}
