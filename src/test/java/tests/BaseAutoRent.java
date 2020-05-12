package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarsCityPage;
import pages.CarsPage;
import pages.HomePage;
import pages.TopNavigation;

public class BaseAutoRent extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Checking the correct displaying and opening of the chosen popular destination")
    @Story("Test popular destinations on the Cars Tab")
    @Test
    public void checkPopularDestinations(){

        HomePage homePage = new HomePage(getDriver());
        TopNavigation topNav = new TopNavigation(getDriver());
        CarsPage carsPage = new CarsPage(getDriver());
        CarsCityPage carsCityPage = new CarsCityPage(getDriver());
        homePage.closeSignInPrompt();
        topNav.goToCarsTab();
        carsPage.goToFirstPopularCity();
        carsPage.goToNewWindow();
        carsCityPage.getTitleText();
        Assert.assertTrue(carsPage.getFirstPopularCity().contains(carsCityPage.getTitleText()), "The wrong city is displayed");
    }

    @Test
    public void getCarsUrl(){

        HomePage homePage = new HomePage(getDriver());
        TopNavigation topNav = new TopNavigation(getDriver());
        homePage.closeSignInPrompt();
        topNav.goToCarsTab();
        System.out.println(getDriver().getCurrentUrl());
    }
}
