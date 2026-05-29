package org.example;

import com.microsoft.playwright.*;

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
            String GENDER = page.locator("label[for='gender-radio-3']").textContent(); // dynamic to get label from the page
            final String MOBILENUMBER = "1234567890";
            final String DATEOFBIRTH = "11 May 1901";
            final String SUBJECT1 = "Social Studies"; // many more options here - full test could check all.
            final String SUBJECT2 = "Maths";
            List<String> SUBJECTS = List.of(SUBJECT1, SUBJECT2);
            final String HOBBY1 = "Sports";
            final String HOBBY2 = "Reading";
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
            // how do these label selectors work??
            Locator hobbies1 = page.locator("label:has-text('" + HOBBY1 + "')");
            Locator hobbies2 = page.locator("label:has-text('" + HOBBY2 + "')");
            Locator currentAddress = page.getByPlaceholder("Current Address");
            Locator submit_button = page.locator("#submit");

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

            hobbies1.click();
            hobbies2.click();

            //pictures code to go here



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
            final int HOBBIES = 7;
            final int ADDRESS = 9;
            // code to assert result table
            List<Locator> rows = page.locator("tr").all();
            String NameSubmission = rows.get(NAME).textContent();
            System.out.println(NameSubmission.contains(FIRSTNAME + " " + LASTNAME));  //1
            // should be assertTrue(emailContent.contains(FIRSTNAME+" "+LASTNAME)) but junit is not firing, so used system out
            String emailSubmission = rows.get(EMAIL_FORM).textContent();
            System.out.println(emailSubmission.contains(EMAIL)); // 2
            String genderSubmission = rows.get(GENDER_FORM).textContent();
            System.out.println(genderSubmission.contains(GENDER)); // 3
            String mobileSubmission = rows.get(MOBILE).textContent();
            System.out.println(mobileSubmission.contains(MOBILENUMBER)); //4
            String dobSubmission = rows.get(DOB).textContent().replace(",", " ");
            System.out.println(dobSubmission.contains(DATEOFBIRTH)); //5
            String subjectsSubmission = rows.get(SUBJECTS_FORM).textContent();
            System.out.println(subjectsSubmission.contains(SUBJECT1) && subjectsSubmission.contains(SUBJECT2));  //6
            String hobbiesSubmission = rows.get(HOBBIES).textContent();
            System.out.println(hobbiesSubmission.contains(HOBBY1) && hobbiesSubmission.contains(HOBBY2)); //7
            String addressSubmission = rows.get(ADDRESS).textContent();
            System.out.println(addressSubmission.contains(ADDRESSLINES.get(0)) && addressSubmission.contains(ADDRESSLINES.get(1)) && addressSubmission.contains(ADDRESSLINES.get(2)) && addressSubmission.contains(ADDRESSLINES.get(3))); //9


            //TO DOS 1. PRINT OUT EVERY ROW IN THE TABLE 6 INDEXES. 86 REPEATED 6 TIMES
            // 2. RENAME 'APP' AND CLOSED PIECE OF WORK
            // 3. CREATE NEW JAVA

        }
    }


}
