package StepDefinition.Other.Darksky;

import Helper.Misc;
import Pages.Other.Darksky.LandingPage;
import Web.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TemperatureSD {

    LandingPage obj = new LandingPage();

    @Given("I am on www.darksky.com")
    public void launchDarkSky() {
        MyDriver.launchUrlOnNewWindow("https://darksky.net/");
    }


    // Time Machine step def
    @When("I click on Time Machine button")
    public void clickTimeMachine() {
        obj.clickTimeMachineBtn2();
        Misc.pause(2);
    }

    @Then("I verify that date in Time Machine is correct")
    public void verifyHighlightedDate() {
        Assert.assertEquals(obj.timeMachineDate(), obj.localDate(), "Test Failed - Wrong Date Selected");
        MyDriver.quitWindows();
    }


    // Temp bars step def
    @When("I expand today details")
    public void clickTodayDetails() {
        obj.clickTodayToggle();
        Misc.pause(2);
    }

    @Then("I verify displayed temp is equal to temp in details")
    public void verifyTempInDetails() {
        Assert.assertEquals(obj.getTodayTemp(), obj.getTodayExtraTemp(), "Test Failed - Displayed temp and expanded details don't match");
        MyDriver.quitWindows();
    }


    // Temp by Location search step def
    @When("^I search temperature using (.+)$")
    public void searchTempFor(String searchFor) {
        obj.enterSearchLocation(searchFor);
        obj.clickSearchButton();
    }

    @Then("^I verify forecast is displayed for (.+)$")
    public void isForecastDisplayed(String searchedFor) {
        Assert.assertTrue(obj.isForecastDisplayed(), "Forecast is not displayed for " + searchedFor);
        MyDriver.quitWindows();
    }
}