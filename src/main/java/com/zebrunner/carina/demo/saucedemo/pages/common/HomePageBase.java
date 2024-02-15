package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.demo.saucedemo.components.BurgerMenu;
import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.enums.SortDropdown;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isHeaderPresent();

    public abstract void clickAddToCartBtn(String productName);

    public abstract void clickAddToCartBtnEnum(ProductName productName);

    public abstract boolean isCounterItemsInCartPresent();

    public abstract CartPageBase clickOnCartBtn();

    public abstract void clickOnBurgerMenu();

    public abstract BurgerMenu getBurgerMenu();
}
