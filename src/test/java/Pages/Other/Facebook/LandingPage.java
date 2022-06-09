package Pages.Other.Facebook;

import Helper.Misc;
import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.By;

import java.util.Set;

public class LandingPage extends Commands {

    // Locator Variables
    // Login Form:
    By loginEmailLocator = By.id("email");
    By loginPassLocator = By.id("pass");
    By loginButtonLocator = By.tagName("button");
    By createNewAccountBtnLocator = By.xpath("//a[@data-testid='open-registration-form-button']");

    // Footer Links:
    //By links = By.xpath("//div[@id='pageFooterChildren']//a");
    By oculusLinkLocator = By.xpath("//a[text()='Oculus']");
    By facebookPayLinkLocator = By.xpath("//a[text()='Facebook Pay']");
    By instagramLinkLocator = By.xpath("//a[text()='Instagram']");
    By portalLinkLocator = By.xpath("//a[text()='Portal']");
    By bulletinLinkLocator = By.xpath("//a[text()='Bulletin']");


    // Methods
    // Login Form:
    public void enterLoginEmail(String loginEmail) {
        type(loginEmailLocator, loginEmail);
    }

    public void enterLoginPassword(String loginPass) {
        type(loginPassLocator, loginPass);
    }

    public void clickLoginButton() {
        click(loginButtonLocator);
    }

    public boolean isLoginButtonEnabled() {
        return findWebElement(loginButtonLocator).isEnabled();
    }

    public boolean isCreateNewAccBtnEnabled() {
        return findWebElement(createNewAccountBtnLocator).isEnabled();
    }

    public void clickCreateNewAccBtn() {
        click(createNewAccountBtnLocator);
    }


    // Footer Links:
    public void clickFooterLinks() {
        click(oculusLinkLocator);
        click(facebookPayLinkLocator);
        click(instagramLinkLocator);
        click(portalLinkLocator);
        click(bulletinLinkLocator);
    }

    public void closeTabs() {
        Set<String> windowID = getAllWindowHandles();
        String instagramID = null;
        for (String id : windowID) {
            MyDriver.getDriver().switchTo().window(id);
            Misc.pause(1);
            if (pageTitle().equals("Instagram")) {
                instagramID = getCurrentWindowHandle();
            }
            if (!pageTitle().equals("Instagram")) {
                MyDriver.getDriver().close();
            }
        }
        MyDriver.getDriver().switchTo().window(instagramID);
    }
}