package Pages.Other.Practice;

import Helper.Misc;
import Pages.Commands1;
import org.openqa.selenium.By;

public class JqueryDragDropPage extends Commands1 {

    // Locator variables
    By frameLocator = By.xpath("//iframe[@class='demo-frame']");
    By sourceToDragLocator = By.xpath("//div[@id='draggable']");
    By targetToDropLocator = By.xpath("//div[@id='droppable']");


    // Methods
    public void switchIntoFrame() {
        switchToFrame(frameLocator);
        // switchToFrame(1);
        // id not available
    }

    public void dragAndDropBox() {
        dragAndDropElement(sourceToDragLocator,targetToDropLocator);
        Misc.pause(3);
    }
}