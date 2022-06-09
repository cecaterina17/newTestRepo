package Tests.Hotel;

import Helper.Misc;
import Pages.Hotel.LandingPage;
import Web.MyDriver;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Booking {

    LandingPage obj = new LandingPage();

    @Test
    public void selectJuneDay() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        obj.clickCheckInBtn();
        obj.selectCheckoutDay("17");
        Misc.pause(3);
        MyDriver.quitWindows();
    }


    @Test
    public void selectFromSuggestions() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        obj.clickSearchBar();
        obj.typeInSearchBar("Colora");
        obj.clickDestinationSuggestion("Denver");
        Misc.pause(3);
        MyDriver.quitWindows();
    }


    @Test
    public void scrollInCalendar() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        obj.clickCheckInBtn();
        obj.selectDayMonthYear("17 November 2022");
        Misc.pause(3);
        MyDriver.quitWindows();
    }


    @Test
    public void verifySearchError() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        obj.clickSearchBtn();
        Assert.assertTrue(obj.isSearchErrorDisplayed());
        MyDriver.quitWindows();
    }


    @Test
    public void verifyTravelerAddFunctions() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        obj.clickOnTravelersBox();
        obj.increaseChildTravelerCount();
        Assert.assertTrue(obj.isTravelerErrorDisplayed());
        obj.selectChildrenAge();
        try {
            Assert.assertFalse(obj.isTravelerErrorDisplayed());
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            Assert.assertTrue(true);
        }
        Misc.pause(3);
        MyDriver.quitWindows();
    }


    @Test
    public void verifyTravelerCountInDestination() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        obj.clickSearchBar();
        obj.typeInSearchBar("Seatt");
        obj.clickDestinationSuggestion("Seattle");
        obj.clickCheckInBtn();
        obj.selectDayMonthYear("17 August 2022");
        obj.clickCalendarDoneBtn();
        obj.clickOnTravelersBox();
        obj.increaseChildTravelerCount();
        obj.selectChildrenAge();
        obj.clickTravelerDoneBtn();
        obj.clickSearchBtn();
        Assert.assertTrue(obj.isTravelersCountSameBeforeAndAfter());
        Misc.pause(3);
        MyDriver.quitWindows();
    }
}