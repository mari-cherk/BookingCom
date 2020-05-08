package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelPage;
import pages.SearchResultsPage;
public class BaseHotelFind extends BaseTest {

    @Test
    public void hotelFind(){

        HomePage homePage = new HomePage();
        SearchResultsPage searchPage = new SearchResultsPage();
        HotelPage hotelPage = new HotelPage();
        homePage.closeSignInPromt();
        homePage.fillWhereField("Киев, Украина");
        homePage.chooseTimePeriod();
        homePage.submitSearch();
        searchPage.chooseFirstFoundHotel();
        searchPage.goToNewWindow();
        Assert.assertTrue(hotelPage.getHotelAddress().contains("Kiev"), "The hotel isn't in Kiev");
    }
}
