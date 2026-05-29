package org.example;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


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
        final String FILE_INPUT = "src/main/resources/Test_Document.txt";  // need to create this file for the test to work - also need to check how this works on different OS's - is there a way to make it dynamic?
        final String DATE_PICKER_TEXT_ENTRY = "05/01/1999";
        final String DATE_PICKER_PICKER_ENTRY = "15";
        final String RESULTS_PAGE_HEADING = "Form submitted";
        final String RESULTS_PAGE_MESSAGE = "Received!";


        // locators
        Locator textInput = page.locator("#my-text-id");
        Locator password = page.locator("input[name='my-password']");
        Locator textArea = page.locator("textarea[name='my-textarea']");
        Locator disabledInput = page.locator("input[name='my-disabled']");
        Locator readonlyInput = page.locator("input[name='my-readonly']");
        Locator returnToIndex = page.getByText("Return to index");
        Locator dropdownSelect = page.locator("select[name='my-select']");
        Locator dropdownDataList = page.locator("input[placeholder='Type to search...']");  // i would like assert the label that displays when its populated
        Locator fileInput = page.locator("input[name='my-file']");
        Locator checkedCheckboxUntick = page.getByLabel("Checked checkbox");
        Locator defaultCheckbox = page.getByLabel("Default checkbox");
        Locator defaultRadio = page.getByLabel("Default radio");
        Locator colorPicker = page.getByLabel("Color picker");
        Locator datePicker = page.getByLabel("Date picker");  // ask co-pilot if getbylable stronger than page.locator?  also john said use different ways
        Locator rangeSlider = page.getByLabel("Example range");
        Locator submit_button = page.getByText("Submit");
        Locator resultHeading = page.getByText("Form submitted");
        Locator resultMessage = page.getByText("Received!");

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
        fileInput.setInputFiles(Paths.get(FILE_INPUT));
        checkedCheckboxUntick.click();
        defaultCheckbox.click();
        defaultRadio.click();
        colorPicker.fill(COLOR_PICKER);
        datePicker.fill(DATE_PICKER_TEXT_ENTRY); // first flow exercised - user enters date as text
        page.locator("td.day").getByText(DATE_PICKER_PICKER_ENTRY).click(); // second flow: in addition asserts the date picker clicking works
        page.locator("body").click();  // user clicks away to close the date picker - matching how the user would use the ui -
        rangeSlider.press("ArrowRight");  // this series verifies a user cliking right to the boundary and then back left down to the middle setting
        rangeSlider.press("ArrowRight");
        rangeSlider.press("ArrowRight");
        rangeSlider.press("ArrowRight");
        rangeSlider.press("ArrowRight");
        rangeSlider.press("ArrowLeft");
        rangeSlider.press("ArrowLeft");
        rangeSlider.press("ArrowLeft");
        rangeSlider.press("ArrowLeft");
        rangeSlider.press("ArrowLeft");
        submit_button.click();
        System.out.println("Form submitted successfully!");

        //RESULTS PAGE
        assertThat(resultHeading).hasText(RESULTS_PAGE_HEADING);
        System.out.println("Results heading assertion passed!");
        assertThat(resultMessage).hasText(RESULTS_PAGE_MESSAGE);
        System.out.println("Results message assertion passed!");

        //need to close it

//
//        List<Locator> rows = page.locator("tr").all();
//        System.out.println("Form submitted successfully!");
//
//
//        System.out.println(rows.get(NAME).textContent());

        //TO DOS 1. PRINT OUT EVERY ROW IN THE TABLE 6 INDEXES. 86 REPEATED 6 TIMES
        // 2. RENAME 'APP' AND CLOSE PIECE OF WORK
        // 3. THEN GO AND DO RNWEBFORM
        // 4. LOOK UP ON NET.  PLAYWRIGHT DOCS FIRST AND THEN STACKOVERFLOW ETC.
        // 5. get junit installed in repo
        // DO THE REPO PUSH TO GITHUB PERSONAL ACCOUNT - SIMULATE DOING A TEST AND SUBMITTING TO A FIRM

    }


}
