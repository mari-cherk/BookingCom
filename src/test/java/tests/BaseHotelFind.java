package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseHotelFind extends BaseTest {


    @Test
    public void hotelFind(){

        homePage.closeSignInPrompt();
        homePage.fillWhereField("Киев, Украина");
        homePage.chooseTimePeriod();
        homePage.submitSearch();
        searchPage.chooseFirstFoundHotel();
        searchPage.goToNewWindow();
        Assert.assertTrue(hotelPage.getHotelAddress().contains("Kiev"), "The hotel isn't in Kiev");
    }
}
