package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

public class CarsCityPage extends BasePage {

    @FindBy(xpath = "//*[@class='sb-searchbox__title-text']")
    public WebElement titleText;

    public CarsCityPage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    public String getTitleText(){
        log.debug("The Title was extracted");
        Reporter.log("The Title was extracted");
        return titleText.getText().split(" ")[3];
    }
}
