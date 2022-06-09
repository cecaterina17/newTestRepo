package StepDefinition.Other.Guru;

import Helper.Misc;
import Pages.Other.Guru.LandingPage;
import Web.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSD {

    LandingPage obj = new LandingPage();

    @Given("^I am on Guru landing page$")
    public void openGugu() {
        MyDriver.launchUrlOnNewWindow("https://demo.guru99.com/test/delete_customer.php/delete_customer.php/");
    }

    @When("^I enter the customer id as (.+)$")
    public void enterCustomerId(String input) {
        obj.enterCustomerId(input);
    }

    @When("I click on Submit button")
    public void clickSubmit() {
        obj.clickSubmitBtn();
        Misc.pause(5);
    }

    @Then("^I verify '(.+)' is displayed$")
    public void verifyCustomerDeleted(String msg) {
        obj.clickOkOnAlert();
        //Assert.assertEquals(obj.getAlertText(), msg, "Error");
        MyDriver.quitWindows();
    }

}