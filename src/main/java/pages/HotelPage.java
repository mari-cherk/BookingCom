package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class HotelPage extends BasePage {

    @FindBy(xpath = "//p[@class='address address_clean']/span")
    public WebElement hotelAddress;

    public HotelPage() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    public String getHotelAddress(){
        return hotelAddress.getText();

    }

}
