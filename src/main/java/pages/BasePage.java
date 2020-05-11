package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static final String siteUrl = "https://www.booking.com";
    public WebDriver driver;


    public BasePage(WebDriver driver){
        this.driver = driver;
        log = Logger.getLogger(this.getClass().getCanonicalName());
    }

    void waitFor(long mills) {
        try {
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void goToNewWindow(){
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        log.debug("Switching to the new window was executed");
        Reporter.log("Switching to the new window was executed");
    }
}
