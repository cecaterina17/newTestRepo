package Pages;

import Web.MyDriver;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Commands {

    /**
     * Methods present in this class
     *
     * - finElement();
     * - findElement --> fluent wait
     * - finElements();
     *
     * - click();
     * - sendKeys();
     * - getText();
     * - getElementAttribute();
     *
     * - isEnabled();
     * - isDisplayed();
     * - isSelected();
     *
     * - getWindowHandles();
     * - getWindowHandle();
     * - getCurrentUrl();
     * - getTitle();
     *
     *  - Actions
     *      - Drag & Drop
     *
     * - scroll methods
     *
     * - select dropdown methods
     *
     * - Calendar methods
     *
     * - Alert
     *      - Switch, Accept, Decline, GetText & Type
     *
     * - Iframe
     *      - Switch by frameID, Index & WebElement.
     *      - Switch back to default content
     */

    // Finding element(s)
    public WebElement findWebElement(By locator) {
        return MyDriver.getDriver().findElement(locator);
    }

    public WebElement findWebElementWithWait(By locator) {
        Wait fWait = new FluentWait(MyDriver.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage("Fluent wait timeout, waited for 30-seconds");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }

    public List<WebElement> findWebElements(By locator) {
        return MyDriver.getDriver().findElements(locator);
    }


    // Clicking, Typing & Get Text
    public void click(By locator) {
        findWebElement(locator).click();
    }

    public void type(By locator, String input) {
        findWebElement(locator).sendKeys(input);
    }

    public String getElementText(By locator) {
        return findWebElement(locator).getText();
    }

    public String getElementAttribute(By locator, String attributeName) {
        return findWebElement(locator).getAttribute(attributeName);
    }

    // Clearing input field
    public void clearField(By locator) {
        findWebElement(locator).clear();
    }


    // isElement boolean methods
    public boolean isElementEnabled(By locator) {
        return findWebElement(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
        return findWebElement(locator).isDisplayed();
    }

    public boolean isElementSelected(By locator) {
        return findWebElement(locator).isSelected();
    }


    // Window handles, URL & Title methods
    public String getCurrentWindowHandle() {
        return MyDriver.getDriver().getWindowHandle();
    }

    public Set<String> getAllWindowHandles() {
        return MyDriver.getDriver().getWindowHandles();
    }

    public String getPageUrl() {
        return MyDriver.getDriver().getCurrentUrl();
    }

    public String pageTitle() {
        return MyDriver.getDriver().getTitle();
    }


    // Action methods
    public void dragAndDropElement(By sourceLocator, By targetLocator) {
        // Source is what u click to drag. Target is where u drop it
        Actions a = new Actions(MyDriver.getDriver());
        WebElement source = findWebElement(sourceLocator);
        WebElement target = findWebElement(targetLocator);
        a.dragAndDrop(source,target).build().perform();
    }


    // Scroll methods
    public WebElement scrollToElement(By locator) {
        WebElement element = null;
        for (int i = 0; i <= 15; i++) {
            try {
                element = findWebElement(locator); // <-- what is the action? What will cause exception ?
                break;                             // When I use it, it finds WebElement right away, without scrolling
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                JavascriptExecutor js = (JavascriptExecutor) MyDriver.getDriver();
                js.executeScript("scrollBy(0,150)");
            }
        }
        return element;
    }

    public void scrollAndClickElement(By locator) {
        for (int i = 0; i < 20; i++) {
            try {
                findWebElement(locator).click();
                break;
            } catch (NoSuchElementException | ElementClickInterceptedException e) {
                JavascriptExecutor js = (JavascriptExecutor) MyDriver.getDriver();
                js.executeScript("scrollBy(0,200)");
            }
        }
    }


    // Calendar, Suggestions & Dropdowns
    public void selectDateInCalendar(By locator, String userDate) {
        // May not be applicable to all calendars. Look for "data-day" attribute
        List<WebElement> allDates = MyDriver.getDriver().findElements(locator);
        for (WebElement dateElement : allDates) {
            String dateValue = dateElement.getAttribute("data-day");
            if (dateValue.equals(userDate)) {
                dateElement.click();
                break;
            }
        }
    }

    public void selectFromSuggestions(By locator, String userSuggestion) {
        List<WebElement> allSuggestions = MyDriver.getDriver().findElements(locator);
        for (WebElement suggestion : allSuggestions) {
            if (suggestion.getText().equalsIgnoreCase(userSuggestion)) {
                suggestion.click();
                break;
            }
        }
    }

    public void selectInDropdown(By locator, String dataToSelect) {
        WebElement element = findWebElement(locator);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(dataToSelect);
    }


    // Alert methods
    Alert myAlert;

    public void switchToAlert() {
        WebDriverWait eWait = new WebDriverWait(MyDriver.getDriver(), 5);
        eWait.until(ExpectedConditions.alertIsPresent());
        myAlert = MyDriver.getDriver().switchTo().alert();
    }

    public void clickPositiveActionBtnOnAlert() {
        if (myAlert == null) {
            switchToAlert();
        }
        myAlert.accept();
    }

    public void clickNegativeActionBtnOnAlert() {
        if (myAlert == null) {
            switchToAlert();
        }
        myAlert.dismiss();
    }

    public String getTextFromAlert() {
        if (myAlert == null) {
            switchToAlert();
        }
        return myAlert.getText();
    }

    public void typeInAlert(String data) {
        if (myAlert == null) {
            switchToAlert();
        }
        myAlert.sendKeys(data);
    }


    // Frame methods
    public void switchToFrame(String frameId) {
        // Method
        MyDriver.getDriver().switchTo().frame(frameId);
    }

    public void switchToFrame(By locator) {
        // Method to switch on Frame using iframe-element
        WebElement myFrame = findWebElement(locator);
        MyDriver.getDriver().switchTo().frame(myFrame);
    }

    public void switchToFrame(int frameIndex) {
        // Method to switch on Frame using iframe-index
        MyDriver.getDriver().switchTo().frame(frameIndex);
    }

    public void switchToMainWindowFromFrame() {
        MyDriver.getDriver().switchTo().defaultContent();
    }

}