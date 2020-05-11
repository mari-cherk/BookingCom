package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.*;
import provider.DriverManager;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected HomePage homePage;
    protected SearchResultsPage searchPage;
    protected HotelPage hotelPage;
    protected CarsPage carsPage;
    protected TopNavigation topNav;
    protected CarsCityPage carsCityPage;

    public static Logger log = Logger.getLogger("devpinoyLogger");

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("Chrome") String browser) {
        driver.set(DriverManager.getDriver(browser));
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initConfiguration();
        initPages();
    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }

    public void initConfiguration() {
        getDriver().get(BasePage.siteUrl);
        log.debug("Navigated to " + BasePage.siteUrl);
        Reporter.log("Navigated to " + BasePage.siteUrl);
        getDriver().manage().window().maximize();
        log.debug("The window is maximized");
        Reporter.log("Navigated to " + BasePage.siteUrl);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            quitBrowser();
        }
    }

    public void quitBrowser() {
        getDriver().quit();
        log.debug("The browser is left");
        Reporter.log("The browser is left");
    }

    public void initPages() {
        homePage = new HomePage(getDriver());
        searchPage = new SearchResultsPage(getDriver());
        hotelPage = new HotelPage(getDriver());
        carsPage = new CarsPage(getDriver());
        topNav = new TopNavigation(getDriver());
        carsCityPage = new CarsCityPage(getDriver());


    }
}
