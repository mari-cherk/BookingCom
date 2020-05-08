package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'header-signin-prompt__close')]")
    public WebElement closePromtButton;

    @FindBy(xpath = "//input[@placeholder='Where are you going?']")
    public WebElement whereField;

    @FindBy(xpath = "//div[contains(@class,'checkin')]//ancestor::*[contains(@class,'sb-date-field__icon')]")
    public WebElement checkInCalendar;

    @FindBy(xpath = "//div[contains(@class,'--next')]")
    public WebElement nextCalendarButton;

    @FindBy(xpath = "//div[@class='bui-calendar__wrapper'][1]//tbody//tr[1]//td[7]")
    public WebElement firstDateButton;

    @FindBy(xpath = "//div[@class='bui-calendar__wrapper'][1]//tbody//tr[2]//td[7]")
    public WebElement lastDateButton;

    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    public WebElement searchButton;

    public HomePage() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    public void closeSignInPromt(){
        closePromtButton.click();
        log.debug("The Sign In pop-up close");
        Reporter.log("The Sign In pop-up close");
    }

    public void fillWhereField(String query){
        whereField.sendKeys(query);
        log.debug("The Where are you going? field is filled in");
        Reporter.log("The Where are you going? field is filled in");
    }

    public void openCalendar(){
        checkInCalendar.click();
        log.debug("The Calendar open");
        Reporter.log("The Calendar open");
    }

    public void nextMonth(){
        nextCalendarButton.click();
        log.debug("The Next month is chosen");
        Reporter.log("The Next month is chosen");
    }

    public void chooseFirstDate(){
        firstDateButton.click();
        log.debug("The First Date is chosen");
        Reporter.log("The First Date is chosen");
    }

    public void chooseLastDate(){
        lastDateButton.click();
        log.debug("The First Date is chosen");
        Reporter.log("The First Date is chosen");
    }

    public void chooseTimePeriod(){
        openCalendar();
        nextMonth();
        chooseFirstDate();
        chooseLastDate();
    }

    public void submitSearch(){
        searchButton.click();
        log.debug("The Search is submitted");
        Reporter.log("The Search is submitted");
    }
}
