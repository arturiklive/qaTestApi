package pages.ui;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);
    }

}