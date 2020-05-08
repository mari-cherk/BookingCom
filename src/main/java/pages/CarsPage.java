package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

public class CarsPage extends BasePage {

    @FindBy(xpath = "//h3[@class='bui-card__title']")
    public WebElement firstPopularCity;

    public CarsPage() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    public String getFirstPopularCity(){
        log.debug("The First Popular City was extracted");
        Reporter.log("The First Popular City was extracted");
        return firstPopularCity.getText();
    }

    public void goToFirstPopularCity(){
        firstPopularCity.click();
        log.debug("The First Popular City is open");
        Reporter.log("The First Popular City is open");
    }
}
