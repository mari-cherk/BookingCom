package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseAutoRent extends BaseTest {

    @Test
    public void checkPopularDestinations(){

        homePage.closeSignInPrompt();
        topNav.goToCarsTab();
        carsPage.goToFirstPopularCity();
        carsPage.goToNewWindow();
        carsCityPage.getTitleText();
        Assert.assertTrue(carsPage.getFirstPopularCity().contains(carsCityPage.getTitleText()), "The wrong city is displayed");
    }
}
