package Pages.Other.Guru;

import Pages.Commands1;
import org.openqa.selenium.By;

public class LandingPage extends Commands1 {

    By cusIdInputLocator = By.name("cusid");
    By submitBtnLocator = By.name("submit");


    public void enterCustomerId(String cusId) {
        type(cusIdInputLocator, cusId);
    }

    public void clickSubmitBtn() {
        click(submitBtnLocator);
    }

    public void clickOkOnAlert() {
        clickPositiveActionBtnOnAlert();
    }

    public String getAlertText() {
        return getTextFromAlert();
    }

}