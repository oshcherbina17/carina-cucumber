package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutInfoPageBase extends AbstractPage {

    public CheckoutInfoPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeInformation(String username);

    public abstract CheckoutOverviewPageBase clickOnContinueBtn();
}
