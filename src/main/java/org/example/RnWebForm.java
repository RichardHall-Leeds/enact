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

        // tools
        //page.pause();

        // inputs
        final String TEXT_INPUT = "You're really growing on me, (Or am I growing on you)";
        final String PASSWORD = "England1996";
        List<String> TEXTAREA = List.of(
                "The darkness fanclub",
                "Flat 4B",
                "Norwich",
                "NW1 1AA"
        );
        // disabled input
        // readonly input

        final String DROPDOWN_SELECT = "Three";
        final String DROPDOWN_DATALIST = "San Francisco";
        final String COLOR_PICKER = "#ff0000";
        final String DATE_PICKER = "05/01/2026";

        // file input




        // file input
        // x 4 checkbox and radio

        // locators
        Locator textInput = page.locator("#my-text-id");
        Locator password = page.locator("input[name='my-password']");
        Locator textArea = page.locator("textarea[name='my-textarea']");
        Locator disabledInput = page.locator("input[name='my-disabled']");
        Locator readonlyInput = page.locator("input[name='my-readonly']");
        Locator returnToIndex = page.getByText("Return to index");
        Locator dropdownSelect = page.locator("select[name='my-select']");
        Locator dropdownDataList = page.locator("input[placeholder='Type to search...']");  // i would like assert the label that displays when its populated
        Locator checkedCheckboxUntick = page.getByLabel("Checked checkbox");
        Locator defaultCheckbox = page.getByLabel("Default checkbox");
        Locator defaultRadio = page.getByLabel("Default radio");
        Locator colorPicker = page.getByLabel("Color picker");
        Locator datePicker = page.getByLabel("Date picker");  // ask co-pilot if getbylable stronger than page.locator?  also john said use different ways

        // actions on page
        textInput.fill(TEXT_INPUT);
        password.fill(PASSWORD);
        textArea.click();
        for (String line : TEXTAREA) {
            textArea.type(line);
            textArea.press("Enter");
        }

//        // return to index - needs junit
//        // returnToIndex.click();
//
//        //copilot code
//        Page newPage = page.waitForPopup(() -> {
//            returnToIndex.click(
//                    new Locator.ClickOptions().setModifiers(Arrays.asList("Control"));
//            );
//        });
//
//        newPage.waitForLoadState();
//        System.out.println("New page URL: " + newPage.url());

        dropdownSelect.selectOption(DROPDOWN_SELECT);
        dropdownDataList.type(DROPDOWN_DATALIST);
        checkedCheckboxUntick.click();
        defaultCheckbox.click();
        defaultRadio.click();
        colorPicker.fill(COLOR_PICKER);
        datePicker.fill(DATE_PICKER);

        //disabledInput - need an assertion here
        //readonlyInput - need an assertion here

//        lastName.fill(LASTNAME);
//        email.fill(EMAIL);
//        gender.click();
//        dateOfBirth.fill(DATEOFBIRTH);
//       // dateOfBirth.press("Enter");
//        email.fill(EMAIL);
//        mobile.fill(MOBILENUMBER);
//        hobbies1.click();
//        hobbies2.click();
//
//        for (String subjects : SUBJECTS) {
//            subjectsInput.fill(subjects);
//           // subjectsInput.press("Enter");
//        }
//
//        currentAddress.click();
//        for (String line : ADDRESSLINES) {
//            currentAddress.type(line);
//        }
//
        // indexes
        //final int NAME = 1;

//        submit_button.click();
//        System.out.println("Form submitted successfully!");
//
//        List<Locator> rows = page.locator("tr").all();
//        System.out.println("Form submitted successfully!");
//
//
//        System.out.println(rows.get(NAME).textContent());

        //TO DOS 1. PRINT OUT EVERY ROW IN THE TABLE 6 INDEXES. 86 REPEATED 6 TIMES
        // 2. RENAME 'APP' AND CLOSE PIECE OF WORK
        // 3. THEN GO AND DO RNWEBFORM
        // LOOK UP ON NET.  PLAYWRIGHT DOCS FIRST AND THEN STACKOVERFLOW ETC.
        // DO THE REPO PUSH TO GITHUB PERSONAL ACCOUNT - SIMULATE DOING A TEST AND SUBMITTING TO A FIRM

    }


}
