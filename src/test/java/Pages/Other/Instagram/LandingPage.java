package Pages.Other.Instagram;

import org.openqa.selenium.By;

public class LandingPage extends Commands1 {

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