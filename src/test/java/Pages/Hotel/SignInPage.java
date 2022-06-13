package Pages.Hotel;

import Pages.Commands;
import org.openqa.selenium.By;

public class SignInPage extends Commands {

    By emailInputLocator = By.xpath("//*[@id='loginFormEmailInput']");
    By passwordInputLocator = By.xpath("//*[@id='loginFormPasswordInput']");
    By loginCheckboxLocator = By.xpath("//input[@type='checkbox']");
    By loginBtnLocator = By.xpath("//*[@id='loginFormSubmitButton']");
    By signInErrorMessageLocator = By.xpath("//*[@id='loginFormErrorBanner']");


    public void enterSignInEmail() {
        type(emailInputLocator, "elliewilliams@lou.com");
    }

    public void enterSignInPassword() {
        type(passwordInputLocator, "blablabla123123");
    }

    public void clickSignInCheckbox() {
        clickWithWait(loginCheckboxLocator);
    }

    public void clickSignInBtn() {
        clickWithWait(loginBtnLocator);
    }

    public boolean verifySignInError() {
        return isElementDisplayed(signInErrorMessageLocator);
    }
}