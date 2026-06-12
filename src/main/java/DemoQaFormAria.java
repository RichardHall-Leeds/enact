import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

// co-pilot session id 5c2cd444-bbab-45d3-976a-2aba8e532cd0
// co-pilot 28/05
public class DemoQaFormAria {
    public static void main(String[] args) {
        try {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://demoqa.com/automation-practice-form/");


            // Inputs
            final String FIRSTNAME = "Richard";
            final String LASTNAME = "Hall";
            final String EMAIL = "richard@email.com";
            String GENDER = page.locator("label[for='gender-radio-3']").textContent();
            final String GENDER2 ="Female";
            final String MOBILENUMBER = "1234567890";
            final String DATEOFBIRTH = "11 May 1901";
            final String SUBJECT1 = "Social Studies"; // many more options here - full test could check all.
            final String SUBJECT2 = "Maths";
            List<String> SUBJECTS = List.of(SUBJECT1, SUBJECT2);
            final String HOBBY1 = "Sports";
            final String HOBBY2 = "Reading";
            List<String> HOBBIES = List.of(HOBBY1, HOBBY2);
            final String FILE_INPUT = "src/main/resources/Test_Document.txt";
            List<String> ADDRESSLINES = List.of(
                    "123 Example Street",
                    "Flat 4B",
                    "Leeds",
                    "LS1 1AA"
            );

            // locators with actions
            Locator firstName = page.getByPlaceholder("First Name");
            firstName.fill(FIRSTNAME);
            System.out.println();

            Locator gender = page.getByLabel(GENDER2);
            gender.check();


            Locator hobby2 = page.getByLabel(HOBBY2);
            hobby2.check();

            Locator submitButton = page.getByRole(AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Submit"));
                submitButton.click();

                // re do mandatory fields in new aria way
            // look up and aria roles and states - leanrn 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

