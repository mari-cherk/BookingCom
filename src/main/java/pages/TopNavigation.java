package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

public class TopNavigation extends BasePage {

    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[2]/span[2]")
    public WebElement carsTab;

    public TopNavigation(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    @Step("Clicking the Cars Tab on the Site Header")
    public void goToCarsTab(){
        carsTab.click();
        log.debug("The Cars Tab is open");
        Reporter.log("The Cars Tab is open");
    }
}
