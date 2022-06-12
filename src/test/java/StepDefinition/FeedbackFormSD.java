package StepDefinition;

import Pages.Hotel.FeedbackPage;
import Pages.Hotel.LandingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FeedbackFormSD {

    FeedbackPage fPage = new FeedbackPage();
    LandingPage lPage = new LandingPage();

    @When("I click on feedback link")
    public void clickFeedbackLink() {
        lPage.clickFeedbackPage();
    }

    @When("I click on feedback submit button")
    public void submitFeedbackForm() {
        fPage.clickFormSubmitBtn();
    }

    @Then("I verify empty form submission error is displayed")
    public void verifyFormSubmissionError() {
        Assert.assertTrue(fPage.isEmptyFormSubmissionErrorDisplayed(), "Test Failed - Error is not displayed");
    }

    @Then("I verify red dotted border around star rating section")
    public void verifyRedDottedBorderAroundRating() {
        Assert.assertTrue(fPage.isRedDottedBorderDisplayed(),"Test Failed - Red dotted border is not displayed");
    }
}