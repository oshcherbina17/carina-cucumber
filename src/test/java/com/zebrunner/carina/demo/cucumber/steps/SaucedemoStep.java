package com.zebrunner.carina.demo.cucumber.steps;

import com.zebrunner.carina.cucumber.CucumberRunner;
import com.zebrunner.carina.demo.ConnectionFactory;
import com.zebrunner.carina.demo.db.mappers.UserMapper;
import com.zebrunner.carina.demo.db.mappers.UserOrderMapper;
import com.zebrunner.carina.demo.db.models.User;
import com.zebrunner.carina.demo.db.models.UserOrder;
import com.zebrunner.carina.demo.saucedemo.pages.common.*;
import com.zebrunner.carina.demo.saucedemo.pages.desktop.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;

import java.util.List;

public class SaucedemoStep extends CucumberRunner {
    LoginPageBase loginPage = null;
    HomePageBase homePage = null;
    CartPageBase cartPage = null;
    CheckoutInfoPageBase checkoutInfoPage = null;
    CheckoutOverviewPageBase checkoutOverviewPage = null;
    OrderCompletionPageBase orderCompletion = null;

    @Given("User logged in to Sauce Demo with {string} credentials from the database")
    public void userLoggedInWithCredentials(String username) {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findByUserName(username);
            String userNameDB = user.getUsername();
            String userPasswordDB = user.getPassword();
            loginPage = new LoginPage(getDriver());
            loginPage.open();
            Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
            homePage = loginPage.login(userNameDB, userPasswordDB);

        }
    }

    @When("User is on the Homepage")
    public void userOpensPage() {
        Assert.assertTrue(homePage.isHeaderPresent(), "Header is not presented");
    }

    @And("User {string} adds products to cart {long}")
    public void userAddsProductsToCart(String username, Long id) {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findByUserName(username);
            UserOrderMapper userOrderMapper = session.getMapper(UserOrderMapper.class);
            List<UserOrder> userOrder = userOrderMapper.findOrdersByUserId(id);
            for (UserOrder productName : userOrder) {
                homePage.clickAddToCartBtn(productName.getProductName());
            }
        }
    }

    @And("User opens cart")
    public void userOpensCart() {
        cartPage = homePage.clickOnCartBtn();
    }

    @Then("User checks the order details")
    public void userChecksTheOrderDetails() {
        Assert.assertTrue(cartPage.getItemsListSize() > 0, "Cart is empty");
    }

    @And("User {string} proceed to checkout")
    public void userProceedToCheckout(String username) {
        checkoutInfoPage = cartPage.clickOnCheckoutInfoBtn();
        checkoutInfoPage.typeInformation(username);
        checkoutOverviewPage = checkoutInfoPage.clickOnContinueBtn();
        Assert.assertTrue(checkoutOverviewPage.isTotalPricePresent(), "Total price ins`t presented");
    }

    @Then("User verify that the ordering was successful")
    public void userVerifyThatTheOrderingWasSuccessful() {
        orderCompletion = checkoutOverviewPage.clickOnFinishBtn();
        Assert.assertTrue(orderCompletion.isCompleteTitlePresent(), "Complete title ins`t presented");
        Assert.assertTrue(orderCompletion.isCompleteTextPresent(), "Complete text ins`t presented");
    }
}
