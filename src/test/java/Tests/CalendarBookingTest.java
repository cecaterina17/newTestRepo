package Tests;

import Pages.Hotel.LandingPage;
import Web.MyDriver;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarBookingTest {

    LandingPage obj = new LandingPage();

    @Test
    public void selectJuneDay() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        obj.clickCheckInBtn();
        obj.selectCheckoutDay("17");
        MyDriver.quitWindows();
    }

    @Test
    public void selectFromSuggestions() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        obj.clickSearchBar();
        obj.typeInSearchBar("Colora");
        obj.clickDestinationSuggestion("Denver");
        MyDriver.quitWindows();
    }

    @Test
    public void scrollInCalendar() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        obj.clickCheckInBtn();
        obj.selectDayMonthYear("17 November 2022");
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
        obj.increaseChildTravelerCount(2);
        Assert.assertTrue(obj.isTravelerErrorDisplayed());
        obj.selectFirstChildAge("3");
        obj.selectSecondChildAge("6");
        try {
            Assert.assertFalse(obj.isTravelerErrorDisplayed());
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            Assert.assertTrue(true);
        }
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
        obj.increaseChildTravelerCount(2);
        obj.selectFirstChildAge("2");
        obj.selectSecondChildAge("5");
        obj.clickTravelerDoneBtn();
        obj.clickSearchBtn();
        Assert.assertTrue(obj.isTravelersCountSameBeforeAndAfter());
        MyDriver.quitWindows();
    }
}
