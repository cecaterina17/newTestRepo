package StepDefinition;

import Pages.Hotel.LandingPage;
import Pages.Hotel.SignInPage;
import Pages.Hotel.SignUpPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SignInSD {

    LandingPage obj = new LandingPage();
    SignUpPage signUpObj = new SignUpPage();
    SignInPage signInObj = new SignInPage();

    @When("I click on sign in field")
    public void clickSignInField() {
        obj.clickSignInField();
    }

    @When("I click on sign in button")
    public void clickSignInBtn() {
        obj.clickSignInBtn();
    }

    @When("I enter email in sign in form")
    public void enterSignInEmail() {
        signInObj.enterSignInEmail();
    }

    @When("I enter password in sign in form")
    public void enterSignInPassword() {
        signInObj.enterSignInPassword();
    }

    @When("I check sign in checkbox")
    public void clickSignInCheckbox() {
        signInObj.clickSignInCheckbox();
    }

    @When("I click sign in button")
    public void clickLogIn() {
        signInObj.clickSignInBtn();
    }

    @Then("I verify sign in error is displayed")
    public void verifySignInError() {
        Assert.assertTrue(signInObj.verifySignInError());
    }

    @When("I click on sign up button")
    public void clickSignUpBtn() {
        obj.clickSignUpBtn();
    }

    @When("I enter email in sign up form")
    public void enterSignUpEmail() {
        signUpObj.enterEmail();
    }

    @When("I enter password in sign up form")
    public void enterSignUpPassword() {
        signUpObj.enterPassword();
    }
}