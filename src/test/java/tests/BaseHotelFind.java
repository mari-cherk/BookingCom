package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelPage;
import pages.SearchResultsPage;

public class BaseHotelFind extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Checking the correct displaying and opening of the hotel for the needed dates")
    @Story("Test hotel selection for selected dates")
    @Test
    public void hotelFind(){
        HomePage homePage = getHomePage();
        SearchResultsPage searchPage = new SearchResultsPage(getDriver());
        HotelPage hotelPage = new HotelPage(getDriver());
        homePage.closeSignInPrompt();
        homePage.fillWhereField("Киев, Украина");
        homePage.chooseTimePeriod();
        homePage.submitSearch();
        searchPage.chooseFirstFoundHotel();
        searchPage.goToNewWindow();
        Assert.assertTrue(hotelPage.getHotelAddress().contains("Kiev"), "The hotel isn't in Kiev");

    }


}
