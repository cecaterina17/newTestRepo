package StepDefinition;

import Pages.Hotel.SignUpPage;
import Web.MyDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SignUpSD {

    SignUpPage sup = new SignUpPage();

    @When("I click on privacy page link")
    public void clickPrivacyPageLink() {
        sup.clickPrivacyPageLink();
    }

    @Then("I verify that link opened privacy page")
    public void verifyPrivacyPage() {
        Assert.assertEquals(sup.getPrivacyPageHeading(),"Privacy Statement","Test Failed - Heading does not match");
    }

    @When("I close privacy page")
    public void closePrivacyPage() {
        sup.closePrivacyPage();
    }

    @When("I click on terms and conditions page link")
    public void clickTermsConditionsLink() {
        sup.clickTermsConditionsLink();
    }

    @When("I verify that it is a correct page")
    public void verifyTermsConditionsPage() {
        Assert.assertEquals(sup.getTermsConditionsPageHeading(),"Terms and Conditions");
    }
}