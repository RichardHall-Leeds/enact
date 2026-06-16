import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

import java.nio.file.Paths;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AriaLocal {

    public static void main(String[] args) {

      final String HTML_BASE = "//src//main//resources//html//aria.html";
        String path = System.getProperty("user.dir");
        String url = "file://" + path + HTML_BASE;

        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
             BrowserContext context = browser.newContext()) {

            Page page = context.newPage();
            page.navigate(url);

            // --- Test data: Inputs ---

            final String FIRSTNAME = "Richard";
            final String LASTNAME = "Hall";
            final String EMAIL_ADDRESS = "richard@ukorg.com";
            final String GENDER = "Male";
            final String MOBILENUMBER = "1234567890";
            final String DATEOFBIRTH = "1901-03-01";
            final String TESTINGSKILLS1 = "Java";
            final String TESTINGSKILLS2 = "JavaScript"; // deliberately using upper case to test the label matching
            final String TESTINGSKILLS3 = "Allure";
            final String TESTINGSKILLS4 = "Playwright";
            final String TESTINGSKILLS5 = "Test Planning";
            List<String> TESTINGSKILLS = List.of(TESTINGSKILLS1, TESTINGSKILLS2, TESTINGSKILLS3, TESTINGSKILLS4, TESTINGSKILLS5);
            final String CV_FILE_INPUT = "src/main/resources/Test_Document.txt";
            final String WORKING_LOCATION_PREFERENCE1 = "Hyrbid Working";
            final String WORKING_LOCATION_PREFERENCE2 = "Fully Remote/Home Working";
            List<String> WORKING_LOCATION_PREFERENCES = List.of(WORKING_LOCATION_PREFERENCE1, WORKING_LOCATION_PREFERENCE2);
            List<String> POSTALADDRESS = List.of(
                    "123 Example Street",
                    "Flat 4B",
                    "Leeds",
                    "LS1 1AA"
            );
            final String COUNTRY = "Northern Ireland";

            //  --- Test data: UI Labels (on as seen page by user) ---
            final String FIRST_NAME_LABEL = "First Name";
            final String LAST_NAME_LABEL = "Last Name";
            final String EMAIL_ADDRESS_LABEL = "Email address";
            final String GENDER_LABEL = "Gender";
            final String GENDER_MALE_LABEL = "Male";
            final String GENDER_FEMALE_LABEL = "Female";
            final String GENDER_OTHER_LABEL  = "Other";
            final String GENDER_NOT_SAY_LABEL = "Prefer Not to Say";
            final String MOBILE_NUMBER_LABEL = "Mobile Number";
            final String DATE_OF_BIRTH_LABEL = "Date of birth";
            final String TESTING_SKILLS_LABEL = "Testing Skills";
            final String CV_UPLOAD_LABEL = "Please upload your CV";
            final String COUNTRY_LABEL = "Country Where you Live";
            final String POSTAL_ADDRESS_LABEL = "Current Postal Address";
            final String SUBMIT_BUTTON_LABEL = "Submit";


            // --- Locators and interactions ---

            Locator firstName = page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName(FIRST_NAME_LABEL).setExact(true));
            firstName.fill(FIRSTNAME);

            Locator lastName = page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName(LAST_NAME_LABEL).setExact(true));
            lastName.fill(LASTNAME);

            Locator email = page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName(EMAIL_ADDRESS_LABEL).setExact(true));
            email.fill(EMAIL_ADDRESS);

            Locator gender = page.getByRole(AriaRole.RADIO,
                    new Page.GetByRoleOptions().setName(GENDER).setExact(true));
            gender.check();

            Locator mobileNumber = page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName(MOBILE_NUMBER_LABEL).setExact(true));
            mobileNumber.fill(MOBILENUMBER);

            Locator dateOfBirth = page.getByLabel(DATE_OF_BIRTH_LABEL,
                    new Page.GetByLabelOptions().setExact(true));
            dateOfBirth.fill(DATEOFBIRTH);

            Locator testingSkills = page.getByRole(AriaRole.COMBOBOX,
            new Page.GetByRoleOptions().setName(TESTING_SKILLS_LABEL).setExact(true));
            for (String skill : TESTINGSKILLS) {
                testingSkills.fill(skill);
            }

            Locator cvUpload = page.getByLabel(CV_UPLOAD_LABEL);
            cvUpload.setInputFiles(Paths.get(CV_FILE_INPUT));

            for (String preference : WORKING_LOCATION_PREFERENCES) {
                page.getByRole(AriaRole.CHECKBOX,
                        new Page.GetByRoleOptions().setName(preference).setExact(true)).check();
            }

            Locator country = page.getByRole(AriaRole.COMBOBOX,
                    new Page.GetByRoleOptions().setName(COUNTRY_LABEL).setExact(true));
            country.selectOption(new SelectOption().setLabel(COUNTRY));

            Locator postalAddress = page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName(POSTAL_ADDRESS_LABEL).setExact(true));
              for (String line : POSTALADDRESS) {
                  postalAddress.pressSequentially(line);
                  postalAddress.press("Enter");
            }

            page.getByRole(AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName(SUBMIT_BUTTON_LABEL).setExact(true)).click();

            // --- Assertions ---
            // Test data: Expected values to be asserted against on the Confirmation page
            final String EXPECTED_HEADING = "Your submission is successful - thank you.";
            final String EXPECTED_REFERENCE = "QA-2026-000123";
            final String EXPECTED_STATUS = "Pending review";
            final String EXPECTED_RESOURCE_LINK = "Playwright Best Practices";
            final String EXPECTED_RESOURCE_URL = "https://playwright.dev/java/docs/best-practices";
            final String SELECTOR_REFERENCE_FIELD = "[data-field='reference']";
            final String SELECTOR_STATUS_FIELD = "[data-field='status']";
            final String SELECTOR_RESOURCE_ITEMS = "#resourceList li";

            // Expected resource counts
            final int EXPECTED_RESOURCE_COUNT = 4;

            // --- Actual Assertions ---
            assertThat(page.getByRole(AriaRole.HEADING,
                    new Page.GetByRoleOptions().setName(EXPECTED_HEADING)))
                    .isVisible();

            assertThat(page.locator(SELECTOR_REFERENCE_FIELD))
                    .hasText(EXPECTED_REFERENCE);

            assertThat(page.locator(SELECTOR_RESOURCE_ITEMS))
                    .hasCount(EXPECTED_RESOURCE_COUNT);

            assertThat(page.getByRole(AriaRole.LINK,
                    new Page.GetByRoleOptions().setName(EXPECTED_RESOURCE_LINK)))
                    .hasAttribute("href", EXPECTED_RESOURCE_URL);

            assertThat(page.locator(SELECTOR_STATUS_FIELD))
                    .hasText(EXPECTED_STATUS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



