package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseAutoRent extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Checking the correct displaying and opening of the chosen popular destination")
    @Story("Test popular destinations on the Cars Tab")
    @Test
    public void checkPopularDestinations(){

        getHomePage().closeSignInPrompt();
        getTopNavigation().goToCarsTab();
        getCarsPage().goToFirstPopularCity();
        getCarsPage().goToNewWindow();
        getCarsCityPage().getTitleText();
        Assert.assertTrue(getCarsPage().getFirstPopularCity().contains(getCarsCityPage().getTitleText()), "The wrong city is displayed");
    }

    @Test
    public void getCarsUrl(){

        getHomePage().closeSignInPrompt();
        getTopNavigation().goToCarsTab();
        System.out.println(getDriver().getCurrentUrl());
    }
}
