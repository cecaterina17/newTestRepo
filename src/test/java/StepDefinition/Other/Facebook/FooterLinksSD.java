package StepDefinition.Other.Facebook;

import Helper.Misc;
import Pages.Other.Instagram.LandingPage;
import Web.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FooterLinksSD {

    Pages.Other.Facebook.LandingPage obj = new Pages.Other.Facebook.LandingPage();
    LandingPage instaObj = new LandingPage();

    @Given("I am on www.facebook.com")
    public void launchFacebook() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
    }

    // Footer links related step def
    @When("I click on Facebook Pay, Oculus, Instagram, Portal and Bulletin")
    public void clickFooterLinks() {
        obj.clickFooterLinks();
        Misc.pause(4);
    }

    @When("I close all tabs except Instagram")
    public void closeTabs() {
        obj.closeTabs();
    }


    // Instagram page related step def
    @Then("I verify number of window-Handles is 1")
    public void verifyWindowHandle() {
        Assert.assertEquals(instaObj.activeWindowCount(), 1, "Test Failed - more than 1 window handle");
    }

    @Then("I verify Page Title is Instagram")
    public void verifyInstagramTitle() {
        Assert.assertEquals(instaObj.instagramPageTitle(), "Instagram", "Test Failed - Title is not Instagram");
    }

    @Then("I verify Login button on Instagram is disabled by default")
    public void verifyLoginBtnIsDisabled() {
        Assert.assertFalse(instaObj.isInstaLoginBtnEnabled());
        MyDriver.quitWindows();
    }
}