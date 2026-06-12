import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

// co-pilot session id 5c2cd444-bbab-45d3-976a-2aba8e532cd0
// co-pilot 28/05
public class DemoQaForm {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
             BrowserContext context = browser.newContext()) {

            Page page = context.newPage();
            page.navigate("https://demoqa.com/automation-practice-form/");


            // Inputs
            final String FIRSTNAME = "Richard";
            final String LASTNAME = "Hall";
            final String EMAIL = "richard@email.com";
            String GENDER = page.locator("label[for='gender-radio-3']").textContent();
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

            // locators
            Locator firstName = page.locator("#firstName");
            Locator lastName = page.locator("#lastName");
            Locator email = page.getByPlaceholder("name@example.com");
            Locator gender = page.getByLabel(GENDER, new Page.GetByLabelOptions().setExact(true));  //dynamically obtained from the page.
            Locator mobile = page.getByPlaceholder("Mobile Number");
            Locator dateOfBirth = page.locator("#dateOfBirthInput");
            Locator subjectsInput = page.locator("#subjectsInput");
            for (String hobby : HOBBIES) {
                page.locator("label:has-text('" + hobby + "')").click();
            }
            Locator uploadPicture = page.locator("#uploadPicture");
            Locator currentAddress = page.getByPlaceholder("Current Address");
            Locator submit_button = page.getByRole(AriaRole.BUTTON,
                            new Page.GetByRoleOptions().setName("Submit"));

            // actions to perform on the page
            firstName.fill(FIRSTNAME);
            lastName.fill(LASTNAME);
            email.fill(EMAIL);
            gender.click();
            mobile.fill(MOBILENUMBER);
            dateOfBirth.fill(DATEOFBIRTH);
            dateOfBirth.press("Enter");

            for (String subjects : SUBJECTS) {
                subjectsInput.fill(subjects);
                subjectsInput.press("Enter");
            }

            //pictures code to go here
            currentAddress.click();
            for (String line : ADDRESSLINES) {
                currentAddress.pressSequentially(line);
                currentAddress.press("Enter");
            }

            // state and city code to go here


            // to resolve modal appearing before form is completed
            page.locator("body").click();
            // ensure submit is visible and stable
            submit_button.scrollIntoViewIfNeeded();
            // optional stabilisation
            page.waitForTimeout(500);
            // force click avoids overlay issues
            submit_button.click(new Locator.ClickOptions().setForce(true));

            System.out.println("Form submitted successfully!");

            // indexes for result table
            final int NAME = 1;
            final int EMAIL_FORM = 2;
            final int GENDER_FORM = 3;
            final int MOBILE = 4;
            final int DOB = 5;
            final int SUBJECTS_FORM = 6;
            final int HOBBIES_FORM = 7;
            final int ADDRESS = 9;
            // code to assert result table
            List<Locator> rows = page.locator("tr").all();
            String NameSubmission = rows.get(NAME).textContent();

            // 10 table rows to asser against in total.
            // could add 11ths for label headers

            // 1 student name
            assertTrue(NameSubmission.contains(FIRSTNAME+" "+LASTNAME),
                "Name row did not contain expected value(s). Actual: " + NameSubmission);

            // 2 student email
            String emailSubmission = rows.get(EMAIL_FORM).textContent();
            assertTrue(emailSubmission.contains(EMAIL),
                    "Email row did not contain expected value(s). Actual: " + emailSubmission);

            // 3 gender
            String genderSubmission = rows.get(GENDER_FORM).textContent();
            assertTrue(genderSubmission.contains(GENDER),
                    "Gender row did not contain expected value(s). Actual: " + genderSubmission);

            // 4 mobile
            String mobileSubmission = rows.get(MOBILE).textContent();
            assertTrue(mobileSubmission.contains(MOBILENUMBER),
                    "Mobile Number row did not contain expected value(s). Actual: " + mobileSubmission);

            // 5 dob
            String dobSubmission = rows.get(DOB).textContent().replace(",", " ");
            assertTrue(dobSubmission.contains(DATEOFBIRTH),
                    "Date of birth row did not contain expected value(s). Actual: " + dobSubmission);

            // 6 subjects
            String subjectsSubmission = rows.get(SUBJECTS_FORM).textContent();
            for (String subject : SUBJECTS) {
                assertTrue(subjectsSubmission.contains(subject),
                        "Subjects row did not contain expected value: " + subject
                        + ". Actual: " + subjectsSubmission);
            }

            // 7 hobbies
            String hobbiesSubmission = rows.get(HOBBIES_FORM).textContent();
            for (String hobby : HOBBIES) {
                assertTrue(hobbiesSubmission.contains(hobby),
                        "Hobbies row did not contain expected value: " + hobby
                        + ". Actual: " + hobbiesSubmission);
            }

            // 8 picture - to do input and execution

            // 9 address
            String addressSubmission = rows.get(ADDRESS).textContent();
            for (String line : ADDRESSLINES) {
                assertTrue(addressSubmission.contains(line),
                        "Address row did not contain expected value: " + line
                                + ". Actual: " + addressSubmission);
            }

            // 10 state and city

        }
    }


}
