package ui;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ui.UiElementsCheckBox;
import pages.ui.UiElementsTextBox;
import pages.ui.UiWidgetsProgressBar;

public class UiThreadQaAllTest extends BaseClass {
    @Test(priority = 1)
    public void testElementsTextBox() {
        UiElementsTextBox uiElementsTextBox = new UiElementsTextBox(driver);
        uiElementsTextBox.openPage("http://85.192.34.140:8081/");
        uiElementsTextBox.textBoxFillForm("Tester", "tester@test.com", "Test Street 5");
        String getTextBoxResult = uiElementsTextBox.getTextBoxResultText();
        Assert.assertTrue(getTextBoxResult.contains("Tester"), "The string does not contain the word - Tester");
        Assert.assertTrue(getTextBoxResult.contains("tester@test.com"), "The string does not contain the word - tester@test.com");
        Assert.assertTrue(getTextBoxResult.contains("Test Street 5"), "The string does not contain the word - Test Street 5");
    }

    @Test(priority = 2)
    public void testElementsCheckBox() {
        UiElementsCheckBox uiElementsCheckBox = new UiElementsCheckBox(driver);
        uiElementsCheckBox.openPage();
        uiElementsCheckBox.clickCheckBox();
        String checkedText = uiElementsCheckBox.getCheckedElements();
        Assert.assertTrue(checkedText.contains("react"), "The string does not contain the word - react");
        Assert.assertTrue(checkedText.contains("private"), "The string does not contain the word - private");
        Assert.assertTrue(checkedText.contains("wordFile"), "The string does not contain the word - wordFile");
    }

    @Test(priority = 3)
    public void testWidgetsProgressBar() throws InterruptedException {
        UiWidgetsProgressBar uiWidgetsProgressBar = new UiWidgetsProgressBar(driver);
        uiWidgetsProgressBar.openPage();
        boolean progressBarStatus = uiWidgetsProgressBar.getProgressBarDone();
        System.out.println(progressBarStatus);
    }
}
