package po;

import com.microsoft.playwright.*;

public class Common {
    static Page page;

    public void open() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(800));
        BrowserContext context = browser.newContext();
        page = context.newPage();
    }

    public void navigate(String url) {
        page.navigate(url);
    }
}

    // TO ADD closure of browser and playwright



