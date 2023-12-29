package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {
    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int getItemsListSize();

    public abstract CheckoutInfoPageBase clickOnCheckoutInfoBtn();
}
