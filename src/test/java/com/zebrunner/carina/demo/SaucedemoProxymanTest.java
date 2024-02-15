package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.HomePageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.OrderCompletionPageBase;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SaucedemoProxymanTest implements IAbstractTest {
    final String URL = "https://www.saucedemo.com";
    final String URL_INVENTORY = "https://www.saucedemo.com/inventory.html";

    @BeforeMethod
    public void beforeClassMethod() {
        getDriver().get(URL);
        getDriver().manage().addCookie(new Cookie("session-username", "standard_user"));
    }

    @Test
    public void testLoginUsingCookies() {
        getDriver().get(URL_INVENTORY);
    }

    @Test(dependsOnMethods = "testLoginUsingCookies")
    public void testVerifyThatOrderSuccessful() {
        getDriver().get(URL_INVENTORY);
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.clickAddToCartBtnEnum(ProductName.BACKPACK);
        homePage.clickOnCartBtn();
        CartPageBase cartPage = homePage.clickOnCartBtn();
        CheckoutInfoPageBase checkoutInfoPage = cartPage.clickOnCheckoutInfoBtn();
        checkoutInfoPage.typeUserInformation("Joe", "Snow", "345675");
        CheckoutOverviewPageBase checkoutOverviewPage = checkoutInfoPage.clickOnContinueBtn();
        Assert.assertTrue(checkoutOverviewPage.isTotalPricePresent(), "Total price ins`t presented");
        OrderCompletionPageBase orderCompletion = checkoutOverviewPage.clickOnFinishBtn();
        Assert.assertTrue(orderCompletion.isCompleteTitlePresent(), "Complete title ins`t presented");
        Assert.assertTrue(orderCompletion.isCompleteTextPresent(), "Complete text ins`t presented");
    }
}
