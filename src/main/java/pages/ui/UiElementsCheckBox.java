package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.utils.WaitingUtils;

public class UiElementsCheckBox {
    private static final By CHECKBOX_LINK = By.xpath("(//li[@class='btn btn-light '])[1]");
    private static final By PLUS_BUTTON_LINK = By.xpath("//button[@class='rct-option rct-option-expand-all']");
    private static final By PRIVATE_LINK = By.xpath("//label[@for='tree-node-private']");
    private static final By REACT_LINK = By.xpath("//label[@for='tree-node-react']");
    private static final By WORD_FILE_LINK = By.xpath("//label[@for='tree-node-wordFile']");
    private static final By GET_CHECKED_ELEMENTS = By.xpath("//div[@class='display-result mt-4']");
    private final WebDriver driver;

    public UiElementsCheckBox(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        WaitingUtils.waitUntilElem(driver, CHECKBOX_LINK, 20);
        driver.findElement(CHECKBOX_LINK).click();
    }

    public void clickCheckBox() {
        WaitingUtils.waitUntilElem(driver, PLUS_BUTTON_LINK, 20);
        driver.findElement(PLUS_BUTTON_LINK).click();
        WaitingUtils.waitUntilElem(driver, WORD_FILE_LINK, 20);
        driver.findElement(PRIVATE_LINK).click();
        driver.findElement(REACT_LINK).click();
        driver.findElement(WORD_FILE_LINK).click();
    }

    public String getCheckedElements() {
        WaitingUtils.waitUntilElem(driver, GET_CHECKED_ELEMENTS, 20);
        return driver.findElement(GET_CHECKED_ELEMENTS).getText();
    }


}