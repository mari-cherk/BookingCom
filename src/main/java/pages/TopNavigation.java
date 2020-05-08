package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

public class TopNavigation extends BasePage {

    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[2]/span[2]")
    public WebElement carsTab;

    public TopNavigation() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    public void goToCarsTab(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        carsTab.click();
        log.debug("The Cars Tab is open");
        Reporter.log("The Cars Tab is open");
    }
}
