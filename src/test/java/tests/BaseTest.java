package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.*;
import provider.DriverManager;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    public static Logger log = Logger.getLogger("devpinoyLogger");

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected static ThreadLocal<HomePage> homePage = new ThreadLocal<>();

    protected static ThreadLocal<SearchResultsPage> searchPage = new ThreadLocal<>();

    protected static ThreadLocal<HotelPage> hotelPage = new ThreadLocal<>();

    protected static ThreadLocal<CarsPage> carsPage = new ThreadLocal<>();

    protected static ThreadLocal<TopNavigation> topNav = new ThreadLocal<>();

    protected static ThreadLocal<CarsCityPage> carsCityPage = new ThreadLocal<>();

    //@BeforeTest
    @BeforeMethod
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

    public HomePage getHomePage(){
        return homePage.get();
    }

    public SearchResultsPage getSearchPage(){
        return searchPage.get();
    }

    public HotelPage getHotelPage(){
        return hotelPage.get();
    }

    public CarsPage getCarsPage(){
        return carsPage.get();
    }

    public TopNavigation getTopNavigation(){
        return topNav.get();
    }

    public CarsCityPage getCarsCityPage(){
        return carsCityPage.get();
    }

    //@AfterTest
    @AfterMethod
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

        homePage.set(new HomePage(getDriver()));
        searchPage.set(new SearchResultsPage(getDriver()));
        hotelPage.set(new HotelPage(getDriver()));
        carsPage.set(new CarsPage(getDriver()));
        topNav.set(new TopNavigation(getDriver()));
        carsCityPage.set(new CarsCityPage(getDriver()));
    }
}
