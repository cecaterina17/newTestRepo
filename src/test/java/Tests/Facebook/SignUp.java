package Tests.Facebook;

import Helper.Misc;
import Pages.Other.Facebook.LandingPage;
import Pages.Other.Facebook.SignUpPage;
import Web.MyDriver;
import org.testng.annotations.Test;

public class SignUp {

    @Test
    public void fillForm() {
        MyDriver.launchUrlOnNewWindow("https://facebook.com/");
        LandingPage lPage = new LandingPage();
        lPage.clickCreateNewAccBtn();
        Misc.pause(1);
        SignUpPage sPage = new SignUpPage();
        sPage.selectBirthdayDate("Jan", "1", "1990");
        MyDriver.quitWindows();
    }
}