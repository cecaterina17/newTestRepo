package StepDefinition.Other.Practice;

import Pages.Other.Practice.JqueryDragDropPage;
import Web.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JqueryFrameSD {

    JqueryDragDropPage obj = new JqueryDragDropPage();

    @Given("I am on Frames page on JqueryUI")
    public void launchW3() {
        MyDriver.launchUrlOnNewWindow("https://jqueryui.com/droppable/");
    }

    @When("I switch to frame")
    public void switchToFrame() {
        obj.switchIntoFrame();
    }

    @Then("I click to drag and drop box")
    public void dragAndDrop() {
        obj.dragAndDropBox();
        MyDriver.quitWindows();
    }

}