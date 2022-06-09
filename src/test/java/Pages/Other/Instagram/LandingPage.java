package Pages.Other.Instagram;

import Pages.Commands;
import org.openqa.selenium.By;

public class LandingPage extends Commands {

    // Locator Variables
    // Login Form:
    By instagramLoginBtnLocator = By.xpath("//button[@disabled]");


    // Methods
    public int activeWindowCount() {
        return getAllWindowHandles().size();
    }

    public String instagramPageTitle() {
        return pageTitle();
    }

    public boolean isInstaLoginBtnEnabled() {
        return isElementEnabled(instagramLoginBtnLocator);
    }

}