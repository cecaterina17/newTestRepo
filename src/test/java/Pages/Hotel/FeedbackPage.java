package Pages.Hotel;

import Pages.Commands;
import org.openqa.selenium.By;

public class FeedbackPage extends Commands {

    By allStarsLocator = By.xpath("//div[@class='radio-group']/div/input");
    By starRatingLegendLocator = By.xpath("//div[@class='radio-legend']//*");
    By commentInputFieldLocator = By.xpath("//*[@id='verbatim']");
    By returnQuestionsDropdownLocator = By.xpath("//*[@id='will-you-return']");
    By emailInputLocator = By.xpath("//*[@id='email_address']");
    By privacyPolicyLinkLocator = By.xpath("//a[contains(text(),'Privacy Policy')]");

    // Booked here before btn locators
    By priorBookingYesBtn = By.xpath("//*[@id='booked-here-before-yes']");
    By priorBookingNoBtn = By.xpath("//*[@id='booked-here-before-no']");

    // Were you successful btn locators
    By wereYouSuccessfulYesBtnLocator = By.xpath("//*[@for='were-you-successful-yes']");
    By wereYouSuccessfulNoBtnLocator = By.xpath("//*[@for='were-you-successful-no']");

    By submitBtnLocator = By.xpath("//*[@id='submit-button']");
    By emptyFormSubmissionErrorLocator = By.xpath("//*[@id='required']");
    By redDottedBorderLocator = By.xpath("//*[contains(@style,'2px dotted rgb')]");


    public void clickFormSubmitBtn() {
        scrollToElementIntoView(submitBtnLocator);
        click(submitBtnLocator);
    }

    public boolean isEmptyFormSubmissionErrorDisplayed() {
        return isElementDisplayed(emptyFormSubmissionErrorLocator);
    }

    public boolean isRedDottedBorderDisplayed() {
        return isElementDisplayed(redDottedBorderLocator);
    }
}