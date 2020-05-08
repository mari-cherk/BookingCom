package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarsCityPage;
import pages.CarsPage;
import pages.HomePage;
import pages.TopNavigation;

public class BaseAutoRent extends BaseTest {

    @Test
    public void checkPopularDestinations(){

        HomePage homePage = new HomePage();
        CarsPage carsPage = new CarsPage();
        TopNavigation topNav = new TopNavigation();
        CarsCityPage carsCityPage = new CarsCityPage();
        homePage.closeSignInPromt();
        topNav.goToCarsTab();
        carsPage.goToFirstPopularCity();
        carsPage.goToNewWindow();
        carsCityPage.getTitleText();
        Assert.assertTrue(carsPage.getFirstPopularCity().contains(carsCityPage.getTitleText()), "The wrong city is displayed");
    }
}
