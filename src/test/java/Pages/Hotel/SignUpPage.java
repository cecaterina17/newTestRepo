package Pages.Hotel;

import Pages.Commands;
import org.openqa.selenium.By;

public class SignUpPage extends Commands {

    By emailInputLocator = By.xpath("//*[@id='signupFormEmailInput']");
    By firstNameInputLocator = By.xpath("//*[@id='signupFormFirstNameInput']");
    By lastNameInputLocator = By.xpath("//*[@id='signupFormLastNameInput']");
    By passwordInputLocator = By.xpath("//*[@id='signupFormPasswordInput']");
    By signUpCheckboxLocator = By.xpath("//*[@id='signUpFormRememberMeCheck']");
    By signUpBtnLocator = By.xpath("//*[@id='signupFormSubmitButton']");


    // Locators for Privacy and Terms & Conditions pages
    By privacyPageLinkLocator = By.xpath("//a[text()='Privacy Statement']");
    By privacyPageHeadingLocator = By.xpath("//h2[text()='Privacy Statement']");
    By termsConditionsPageLinkLocator = By.xpath("//a[text()='Terms and Conditions']");
    By termsConditionsHeadingLocator = By.xpath("//h1[text()='Terms and Conditions']");

    public void enterEmail() {
        type(emailInputLocator, "joelwilliams@lou.com");
    }

    public void enterPassword() {
        type(passwordInputLocator, "blablabla123@");
    }


    // Privacy Page Methods
    String signUpPageWindowHandle;

    public void clickPrivacyPageLink() {
        click(privacyPageLinkLocator);
        signUpPageWindowHandle = getCurrentWindowHandle();
        switchToSecondBrowserWindow(signUpPageWindowHandle);
    }

    public String getPrivacyPageHeading() {
        return getElementText(privacyPageHeadingLocator);
    }

    public void closePrivacyPage() {
        closeActiveBrowserWindow();
        switchToOriginalWindow(signUpPageWindowHandle);
    }


    // Terms and Conditions Methods
    public void clickTermsConditionsLink() {
        click(termsConditionsPageLinkLocator);
        switchToSecondBrowserWindow(signUpPageWindowHandle);
    }

    public String getTermsConditionsPageHeading() {
        return getElementText(termsConditionsHeadingLocator);
    }
}