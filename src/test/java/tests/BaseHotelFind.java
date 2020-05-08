package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelPage;
import pages.SearchResultsPage;


public class BaseHotelFind extends BaseTest {



    @Test
    public void hotelFind(){

        HomePage homePage = new HomePage();
        SearchResultsPage searchPage = new SearchResultsPage();
        homePage.closeSignInPromt();
        homePage.fillWhereField("Киев, Украина");
        homePage.chooseTimePeriod();
        homePage.submitSearch();
        searchPage.chooseFirstFoundHotel();
    }
}
