package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'sr_item  sr_item_new sr_item_default sr_property_block  sr_flex_layout ')]//span[contains(@class,'sr-hotel__name')]")
    public List<WebElement> foundHotelsNames;

    public SearchResultsPage() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    public void chooseFirstFoundHotel(){
        if(foundHotelsNames.size() > 0) {
            foundHotelsNames.get(0).click();
            log.debug("The First found hotel is chosen");
            Reporter.log("The First found hotel is chosen");
        } else {
            System.out.println("No search result");
            log.debug("No search result");
            Reporter.log("No search result");
        }
    }
}
