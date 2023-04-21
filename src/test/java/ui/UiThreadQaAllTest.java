package ui;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.ui.UiElements;

public class UiThreadQaAllTest extends BaseClass {
    @Test
    public void testElementsTextbox() throws InterruptedException {
        UiElements uiElements = new UiElements(driver);
        uiElements.openPage("http://85.192.34.140:8081/");
        uiElements.textBoxFillForm("Tester", "tester@test.com", "Test Street 5");

        assert driver.getTitle().contains("ThreadQa");

        Thread.sleep(2000);
    }
}
