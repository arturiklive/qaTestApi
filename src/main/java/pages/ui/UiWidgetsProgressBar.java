package pages.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.utils.WaitingUtils;

public class UiWidgetsProgressBar {
    private static final By WIDGETS_LINK = By.xpath("(//span[@class='group-header'])[4]");
    private static final By PROGRESS_BAR_LINK = By.xpath("(//div[@class='element-list collapse show']//li)[5]");
    private static final By PROGRESS_BAR_START_BUTTON = By.id("startStopButton");
    private static final By PROGRESS_BAR_POSITION = By.xpath("//div[starts-with(@class,'progress-bar bg-')]");
    private final WebDriver driver;

    public UiWidgetsProgressBar(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Progress Bar page")
    @Description("Open Progress Bar page - description")
    public void openPage() {
        WaitingUtils.waitUntilElem(driver, WIDGETS_LINK, 20);
        driver.findElement(WIDGETS_LINK).click();
        WaitingUtils.waitUntilElem(driver, PROGRESS_BAR_LINK, 20);
        driver.findElement(PROGRESS_BAR_LINK).click();
    }

    @Step("Start Progress Bar and wait until it is 100% loaded")
    public boolean waitForProgressBar() throws InterruptedException {
        WaitingUtils.waitUntilElem(driver, PROGRESS_BAR_START_BUTTON, 20);
        driver.findElement(PROGRESS_BAR_START_BUTTON).click();

        int counter = 0;
        while (counter < 10) {
            if (driver.findElement(PROGRESS_BAR_POSITION).getAttribute("aria-valuenow").equals("100"))
                return true;
            Thread.sleep(5000);
            counter++;
        }
        return false;
    }


}