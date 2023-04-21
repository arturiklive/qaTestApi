package ui;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.ui.HomePage;

public class testTest extends BaseClass {
    @Test
    public void testSearch() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openPage("http://85.192.34.140:8081/");

        assert driver.getTitle().contains("ThreadQa");
    }
}
