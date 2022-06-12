package Pages.Other.Facebook;

import Pages.Commands1;
import org.openqa.selenium.By;

public class LoginErrorPage extends Commands1 {

    // Locator Variables
    By loginErrorLocator = By.xpath("//div[text()='The email or mobile number you entered isn’t connected to an account. ']");


    // Methods
    public boolean isLoginErrorDisplayed() {
        return isElementDisplayed(loginErrorLocator);
    }

}