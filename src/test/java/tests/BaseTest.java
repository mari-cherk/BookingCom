package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;
import provider.DriverManager;

public class BaseTest {

    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("Chrome") String browser){
        BasePage.driver = DriverManager.getDriver("browser");
        BasePage.initConfiguration();
    }


    @AfterTest
    public void tearDown() {
        if (BasePage.driver != null) {
            BasePage.quitBrowser();
        }
    }
}
