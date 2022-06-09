package Pages.Other.Facebook;

import Pages.Commands;
import org.openqa.selenium.By;

public class LoginErrorPage extends Commands {

    // Locator Variables
    By loginErrorLocator = By.xpath("//div[text()='The email or mobile number you entered isn’t connected to an account. ']");


    // Methods
    public boolean isLoginErrorDisplayed() {
        return isElementDisplayed(loginErrorLocator);
    }

}