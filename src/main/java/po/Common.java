package po;

import com.microsoft.playwright.*;

public class Common {
    Page page;

    public void open() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        page = context.newPage();

    }

    public void navigate(String url) {
        page.navigate(url);
    }
}


