package org.example;

import com.microsoft.playwright.*;

import java.util.List;


public class RnWebForm {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://www.selenium.dev/selenium/web/web-form.html");


        // inputs
        final String TEXT_INPUT = "You're really growing on me, (Or am I growing on you)";
        final String PASSWORD = "England1996";
        List<String> TEXTAREA = List.of(
                "123 Example Street",
                "Flat 4B",
                "Leeds",
                "LS1 1AA"
        );
        final String EMAIL = "richard@email.com";
        final String MOBILENUMBER = "1234567890";
        final String DATEOFBIRTH = "11 May 1901";
        final String SUBJECT1 = "Social Studies";
        final String SUBJECT2 = "Maths";
        List<String> SUBJECTS = List.of(SUBJECT1, SUBJECT2);
        final String HOBBY1 = "Sports";
        final String HOBBY2 = "Reading";

        final String STATE = "NCR";
        final String CITY = "Lucknow";

        // locators
        Locator firstName = page.locator("#firstName");
        Locator lastName = page.locator("#lastName");
        Locator email = page.getByPlaceholder("name@example.com");
        Locator gender = page.locator("#gender-radio-3");
        Locator mobile= page.getByPlaceholder("Mobile Number");
        Locator dateOfBirth = page.locator("#dateOfBirthInput");
        Locator hobbies1 = page.locator("label:has-text('" + HOBBY1 + "')");
        Locator hobbies2 = page.locator("label:has-text('" + HOBBY2 + "')");
        Locator subjectsInput = page.locator("#subjectsInput");
        Locator currentAddress = page.getByPlaceholder("Current Address");
        Locator submit_button= page.locator("#submit");

        // indexes
        final int NAME = 1;

        // actions on page
        firstName.fill(FIRSTNAME);
        lastName.fill(LASTNAME);
        email.fill(EMAIL);
        gender.click();
        dateOfBirth.fill(DATEOFBIRTH);
       // dateOfBirth.press("Enter");
        email.fill(EMAIL);
        mobile.fill(MOBILENUMBER);
        hobbies1.click();
        hobbies2.click();

        for (String subjects : SUBJECTS) {
            subjectsInput.fill(subjects);
           // subjectsInput.press("Enter");
        }

        currentAddress.click();
        for (String line : ADDRESSLINES) {
            currentAddress.type(line);
        }

        submit_button.click();
        System.out.println("Form submitted successfully!");

        List<Locator> rows = page.locator("tr").all();
        System.out.println("Form submitted successfully!");


        System.out.println(rows.get(NAME).textContent());

        //TO DOS 1. PRINT OUT EVERY ROW IN THE TABLE 6 INDEXES. 86 REPEATED 6 TIMES
        // 2. RENAME 'APP' AND CLOSE PIECE OF WORK
        // 3. THEN GO AND DO RNWEBFORM
        // LOOK UP ON NET.  PLAYWRIGHT DOCS FIRST AND THEN STACKOVERFLOW ETC.
        // DO THE REPO PUSH TO GITHUB PERSONAL ACCOUNT - SIMULATE DOING A TEST AND SUBMITTING TO A FIRM

    }


}
