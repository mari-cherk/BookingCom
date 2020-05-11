package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;


public class HotelPage extends BasePage {

    @FindBy(xpath = "//p[@class='address address_clean']/span")
    public WebElement hotelAddress;

    public HotelPage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    public String getHotelAddress(){
        log.debug("The Hotel Address is extracted");
        Reporter.log("The Hotel Address is extracted");
        return hotelAddress.getText();
    }

}
