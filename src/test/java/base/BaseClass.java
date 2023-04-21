package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    protected WebDriver driver;

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }
    @BeforeClass
    public void setUpDriver() {
        driver = getDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }
}
