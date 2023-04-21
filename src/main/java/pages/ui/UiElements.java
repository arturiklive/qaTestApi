package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.utils.WaitingUtils;

public class UiElements {
    private final WebDriver driver;
    private static final By ELEMENTS_LINK = By.xpath("(//div[@class='card-body']//h5)[1]");
    private static final By TEXTBOX_LINK = By.xpath("(//ul[@class='menu-list']//span)[1]");
    private static final By TEXTBOX_INPUT_FULL_NAME = By.id("userName");
    private static final By TEXTBOX_INPUT_EMAIL = By.id("userEmail");
    private static final By TEXTBOX_INPUT_CURRENT_ADDRESS = By.id("currentAddress");
    private static final By TEXTBOX_INPUT_PERMANENT_ADDRESS = By.id("permanentAddress");
    private static final By TEXTBOX_FORM_SUBMIT = By.id("submit");

    public UiElements(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) {
        driver.get(url);
        WaitingUtils.waitUntilElem(driver, ELEMENTS_LINK, 20);
    }

    public void goToTextBox () {
        WaitingUtils.waitUntilElem(driver, ELEMENTS_LINK, 20);
        driver.findElement(ELEMENTS_LINK).click();

        WaitingUtils.waitUntilElem(driver, TEXTBOX_LINK, 20);
        driver.findElement(TEXTBOX_LINK).click();
    }

    public void textBoxFillForm(String name, String email, String address) {
        goToTextBox();

        WaitingUtils.waitUntilElem(driver, TEXTBOX_INPUT_FULL_NAME, 20);
        driver.findElement(TEXTBOX_INPUT_FULL_NAME).sendKeys(name);

        WaitingUtils.waitUntilElem(driver, TEXTBOX_INPUT_EMAIL, 20);
        driver.findElement(TEXTBOX_INPUT_EMAIL).sendKeys(email);

        WaitingUtils.waitUntilElem(driver, TEXTBOX_INPUT_CURRENT_ADDRESS, 20);
        driver.findElement(TEXTBOX_INPUT_CURRENT_ADDRESS).sendKeys(address);

        WaitingUtils.waitUntilElem(driver, TEXTBOX_INPUT_PERMANENT_ADDRESS, 20);
        driver.findElement(TEXTBOX_INPUT_PERMANENT_ADDRESS).sendKeys(address);

        textBoxFillFormSubmit();
    }

    public void textBoxFillFormSubmit() {
        WaitingUtils.waitUntilElem(driver, TEXTBOX_INPUT_PERMANENT_ADDRESS, 20);
        driver.findElement(TEXTBOX_FORM_SUBMIT).click();
    }

}