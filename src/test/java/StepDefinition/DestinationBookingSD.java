package StepDefinition;

import Pages.Hotel.LandingPage;
import Pages.Hotel.SearchResultsPage;
import Web.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class DestinationBookingSD {

    LandingPage obj = new LandingPage();
    SearchResultsPage srp = new SearchResultsPage();

    @Given("I am on www.hotels.com")
    public void launchHotels() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com/");
    }


    // Search error step def
    @When("I click destination search button")
    public void clickSearchBtn() {
        obj.clickSearchBtn();
    }

    @Then("I verify search error is displayed")
    public void verifySearchErrorMessage() {
        Assert.assertTrue(obj.isSearchErrorDisplayed());
    }


    // Travelers details step def
    @When("I click travelers field")
    public void clickTravelersField() {
        obj.clickOnTravelersBox();
    }

    int totalAdultCount;

    @When("^I add (.+) adult travelers$")
    public void addAdults(int adultCount) {
        obj.increaseAdultTravelerCount(adultCount);
        totalAdultCount = Integer.valueOf(adultCount);
    }

    @When("^I add (.+) child travelers$")
    public void addChildren(int childCount) {
        obj.increaseChildTravelerCount(childCount);
    }

    @Then("I verify age error is displayed")
    public void verifyAgeErrorIsDisplayed() {
        Assert.assertTrue(obj.isTravelerErrorDisplayed());
    }

    @When("^I select first child's age as (.+)$")
    public void selectFirstChildAge(String age) {
        obj.selectFirstChildAge(age);
    }

    @When("^I select second child's age as (.+)$")
    public void selectSecondChildAge(String age) {
        obj.selectSecondChildAge(age);
    }

    @Then("I verify age error is not displayed")
    public void verifyAgeErrorNotDisplayed() {
        try {
            Assert.assertFalse(obj.isTravelerErrorDisplayed());
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            Assert.assertTrue(true);
        }
    }

    @When("I click travelers done button")
    public void clickTravelersDoneBtn() {
        obj.clickTravelerDoneBtn();
    }

    @Then("I verify traveler count after search is same as before")
    public void verifyTravelerCountBeforeAndAfterSearch() {
        Assert.assertTrue(obj.isTravelersCountSameBeforeAndAfter());
    }

    @Then("I verify total count of travelers is correct")
    public void verifyTravelerCountBeforeSearch() {
        Assert.assertTrue(obj.isTotalTravelerCountCorrect(), "Fail - Added traveler count and displayed total don't match");
    }


    // Search destination step def
    @When("I click search bar")
    public void slickSearchBar() {
        obj.clickSearchBar();
    }

    @When("^I type destination (.+)$")
    public void typeDestination(String inputDestination) {
        obj.typeInSearchBar(inputDestination);
    }

    @When("^I click on (.+) from destination suggestion$")
    public void clickSuggestion(String place) {
        obj.clickDestinationSuggestion(place);
    }


    // Calendar step def
    @When("I click on Check In field")
    public void clickCheckIn() {
        obj.clickCheckInBtn();
    }

    @When("I click on Check Out field")
    public void clickCheckOut() {
        obj.clickCheckOutBtn();
    }

    @When("^I select date (.+)$")
    public void selectDate(String dateCal) {
        obj.selectDayMonthYear(dateCal);
    }

    @When("I click calendar done button")
    public void clickCalendarDoneBtn() {
        obj.clickCalendarDoneBtn();
    }

    @Then("I verify disabled day count is correct")
    public void verifyCheckInDisabledDayCount() {
        Assert.assertTrue(obj.isDisabledPastDayCountCorrect());
    }

    @Then("I verify previous month button is disabled")
    public void verifyPreviousMonthBtn() {
        Assert.assertTrue(obj.isPreviousMonthBtnDisabled());
    }

    @When("I quit browser")
    public void quitBrowserWindows() {
        MyDriver.quitWindows();
    }


    // Search Page step def
    @Then("I verify Tell us how we can improve our site is displayed")
    public void verifyFeedbackSentenceIsDisplayed() {
        Assert.assertTrue(srp.isShareFeedbackTextDisplayed(),"Test Failed - Sentence is not displayed");
    }

    @Then("I verify share feedback button is displayed")
    public void verifyShareFeedbackBtnIsDisplayed() {
        Assert.assertTrue(srp.isShareFeedbackBtnDisplayed(),"Test Failed - Share feedback btn is not displayed");
    }

    @Then("I verify share feedback button is enabled")
    public void verifyShareFeedbackBtnIsEnabled() {
        Assert.assertTrue(srp.isShareFeedbackBtnEnabled(),"Test Failed - Share feedback btn is not enabled");
    }
}