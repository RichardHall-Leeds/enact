package steps;

import io.cucumber.java.en.Given;

public class Common {
    private final String QA = "https://www.enact.co.uk/";
    private final String PP = "https://pp.trunarrative.cloud/ui/platform/";
    // vm option line -Denv=pp
    po.Common common = new po.Common();

    @Given("I open a browser")
    public void openABrowser() {
        common.open();
    }

    @Given("I navigate to the platform")
    public void navigateToPlatform() {
        String env = System.getProperty("env", "qa");
        if (env.equals("qa")) {
            common.navigate(QA);
        } else if (env.equals("pp")) {
            common.navigate(PP);
        } else {
            throw new IllegalArgumentException("Unknown env: " + env);
        }

//    @Given("I navigate to the platform")
//    public void navigateToPlatform() {
//        String env = System.getProperty("env", "qa");
//        switch (env) {
//            case "qa" -> common.navigate(QA);
//            case "pp" -> common.navigate(PP);
//            default -> throw new IllegalArgumentException("Unknown env: " + env);
//        }

    }
}

