package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseHotelFind extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Checking the correct displaying and opening of the hotel for the needed dates")
    @Story("Test hotel selection for selected dates")
    @Test
    public void hotelFind(){

        getHomePage().closeSignInPrompt();
        getHomePage().fillWhereField("Киев, Украина");
        getHomePage().chooseTimePeriod();
        getHomePage().submitSearch();
        getSearchPage().chooseFirstFoundHotel();
        getSearchPage().goToNewWindow();
        Assert.assertTrue(getHotelPage().getHotelAddress().contains("Kiev"), "The hotel isn't in Kiev");

    }


}
