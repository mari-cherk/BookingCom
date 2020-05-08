package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static final String siteUrl = "https://www.booking.com";
    public static WebDriver driver;


    public static void initConfiguration() {
        driver.get(siteUrl);
        log.debug("Navigated to " + siteUrl);
        Reporter.log("Navigated to " + siteUrl);
        driver.manage().window().maximize();
        log.debug("The window is maximized");
        Reporter.log("Navigated to " + siteUrl);

    }

    void waitFor(long mills) {
        try {
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void quitBrowser() {
        driver.quit();
        log.debug("The browser is left");
        Reporter.log("The browser is left");
    }

    public void safeAlertDissmiss() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {

        }
    }
}
