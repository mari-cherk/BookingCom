package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a[@class='hotel_name_link url']")
    public List<WebElement> foundHotelsNames;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    @Step("Choosing the First found hotel on the Search Results page")
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
