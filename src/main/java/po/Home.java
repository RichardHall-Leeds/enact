package po;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Home extends Common {

      public void acceptCookies() {
        Locator cookiesAcceptAllButton;

        cookiesAcceptAllButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Accept All").setExact(true));
        cookiesAcceptAllButton.click();
    }
}
