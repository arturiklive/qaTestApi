package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.utils.WaitingUtils;

public class UiWidgetsProgressBar {
    private static final By WIDGETS_LINK = By.xpath("(//span[@class='group-header'])[4]");
    private static final By PROGRESS_BAR_LINK = By.xpath("(//div[@class='element-list collapse show']//li)[5]");
    private static final By PROGRESS_BAR_START_BUTTON = By.id("startStopButton");
    private static final By PROGRESS_BAR_POSITION = By.id("progressBar");
    private final WebDriver driver;

    public UiWidgetsProgressBar(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        WaitingUtils.waitUntilElem(driver, WIDGETS_LINK, 20);
        driver.findElement(WIDGETS_LINK).click();
        WaitingUtils.waitUntilElem(driver, PROGRESS_BAR_LINK, 20);
        driver.findElement(PROGRESS_BAR_LINK).click();
    }

    public boolean getProgressBarDone() throws InterruptedException {
        WaitingUtils.waitUntilElem(driver, PROGRESS_BAR_START_BUTTON, 20);
        driver.findElement(PROGRESS_BAR_START_BUTTON).click();
        Thread.sleep(5000);

        int maxTries = 10;
        int tries = 0;

        while (true) {
            if (driver.findElement(PROGRESS_BAR_POSITION).getAttribute("aria-valuenow").equals("100")) {
                // progress bar заполнен до конца - возвращаем true
                return true;
            }
            // progress bar еще не заполнен до конца - ждем 1 секунду и проверяем снова
            Thread.sleep(1000);
            tries++;

            if (tries == maxTries) {
                // достигнуто максимальное количество проверок - выходим из цикла и возвращаем false
                break;
            }
        }

// progress bar не заполнен до конца за отведенное время - возвращаем false
        return false;

    }


}