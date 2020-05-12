package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'header-signin-prompt__close')]")
    public WebElement closePromptButton;

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

    public HomePage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    @Step("Closing Sign In Prompt on the Home Page")
    public void closeSignInPrompt(){
        closePromptButton.click();
        log.debug("The Sign In pop-up is close");
        Reporter.log("The Sign In pop-up is close");
    }

    @Step("Filling in the Where are you going? field on the Home page")
    public void fillWhereField(String query){
        whereField.sendKeys(query);
        log.debug("The Where are you going? field is filled in");
        Reporter.log("The Where are you going? field is filled in");
    }

    @Step("Opening the calendar on the Home page")
    public void openCalendar(){
        checkInCalendar.click();
        log.debug("The Calendar is open");
        Reporter.log("The Calendar is open");
    }

    @Step("Choosing the next month in the calendar on the Home page")
    public void nextMonth(){
        nextCalendarButton.click();
        log.debug("The Next month is chosen");
        Reporter.log("The Next month is chosen");
    }

    @Step("Choosing the first date in the calendar on the Home page")
    public void chooseFirstDate(){
        firstDateButton.click();
        log.debug("The First Date is chosen");
        Reporter.log("The First Date is chosen");
    }

    @Step("Choosing the second date in the calendar on the Home page")
    public void chooseLastDate(){
        lastDateButton.click();
        log.debug("The First Date is chosen");
        Reporter.log("The First Date is chosen");
    }

    @Step("Choosing the time period in the calendar on the Home page")
    public void chooseTimePeriod(){
        openCalendar();
        nextMonth();
        chooseFirstDate();
        chooseLastDate();
        log.debug("The TIme Period is chosen");
        Reporter.log("The TIme Period is chosen");
    }

    @Step("Submitting the search on the Home page")
    public void submitSearch(){
        searchButton.click();
        log.debug("The Search is submitted");
        Reporter.log("The Search is submitted");
    }
}
