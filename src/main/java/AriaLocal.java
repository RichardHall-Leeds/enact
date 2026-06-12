import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// co-pilot session id 5c2cd444-bbab-45d3-976a-2aba8e532cd0
// co-pilot 28/05
public class AriaLocal {
    public static void main(String[] args) {

      final String HTML_BASE = "//src//main//java//aria.html";
        String path = System.getProperty("user.dir");
        String url = "file://" + path + HTML_BASE;

        try {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate(url);

            // Inputs
            final String GENDER = "male";
            final String COUNTRY = "Northern Ireland";

            // Locataros and interactions

            // Locator gender = page.getByLabel(GENDER);
            // gender.check();

            page.selectOption("#country", new SelectOption().setLabel(COUNTRY));

            // Assertions

            assertThat(page.locator("#country"))
                    .hasText(COUNTRY);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//declare a disabled field and check its disabled
// run through the getbylabel, get by row - look at official playwrite documentation for java
