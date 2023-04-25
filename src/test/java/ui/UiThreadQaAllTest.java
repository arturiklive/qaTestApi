package ui;

import base.BaseClass;
import base.TestVariables;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ui.UiElementsCheckBox;
import pages.ui.UiElementsTextBox;
import pages.ui.UiWidgetsProgressBar;

public class UiThreadQaAllTest extends BaseClass {

    @Test(priority = 1, description = "UI Testings - Text Box")
    @Description("Filling Elements/Text Box by demo data, then execute and compare.")
    public void testElementsTextBox() {
        UiElementsTextBox uiElementsTextBox = new UiElementsTextBox(driver);
        uiElementsTextBox.openPage(TestVariables.TEST_URL);
        String errMsg = "The string does not contain the word - ";
        uiElementsTextBox.textBoxFillForm(TestVariables.USER_NAME, TestVariables.USER_EMAIL, TestVariables.USER_ADDRESS);
        String getTextBoxResult = uiElementsTextBox.getTextBoxResultText();
        Assert.assertTrue(getTextBoxResult.
                contains(TestVariables.USER_NAME), errMsg + TestVariables.USER_NAME);
        Assert.assertTrue(getTextBoxResult.
                contains(TestVariables.USER_EMAIL), errMsg + TestVariables.USER_EMAIL);
        Assert.assertTrue(getTextBoxResult.
                contains(TestVariables.USER_ADDRESS), errMsg + TestVariables.USER_ADDRESS);
    }

    @Test(priority = 2, description = "UI Testings - CheckBox")
    @Description("Checking 3 elements, then compare.")
    public void testElementsCheckBox() {
        UiElementsCheckBox uiElementsCheckBox = new UiElementsCheckBox(driver);
        uiElementsCheckBox.openPage();
        uiElementsCheckBox.clickCheckBox();
        String checkedText = uiElementsCheckBox.getCheckedElements();
        Assert.assertTrue(checkedText.contains("react"), "The string does not contain the word - react");
        Assert.assertTrue(checkedText.contains("private"), "The string does not contain the word - private");
        Assert.assertTrue(checkedText.contains("wordFile"), "The string does not contain the word - wordFile");
    }

    @Test(priority = 3, description = "UI Testings - Progress Bar")
    @Description("Starting Progress Bar. Check if fully loaded, when Progress Bar reaches 100%.")
    public void testWidgetsProgressBar() throws InterruptedException {
        UiWidgetsProgressBar uiWidgetsProgressBar = new UiWidgetsProgressBar(driver);
        uiWidgetsProgressBar.openPage();
        boolean progressBarStatus = uiWidgetsProgressBar.waitForProgressBar();
        Assert.assertTrue(progressBarStatus, "Progress bar validating is failed");
    }
}
