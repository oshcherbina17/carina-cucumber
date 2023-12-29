package com.zebrunner.carina.demo.saucedemo.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private ExtendedWebElement logout;

    @FindBy(xpath = "//a[@id='inventory_sidebar_link']")
    private ExtendedWebElement allItemsLink;

    @FindBy(xpath = "//a[@id='about_sidebar_link']")
    private ExtendedWebElement aboutLink;

    public BurgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLogoutPresent() {
        return logout.isPresent();
    }

    public boolean isAllItemsLinkPresent() {
        return allItemsLink.isPresent();
    }

    public boolean isAboutLinkPresent() {
        return aboutLink.isPresent();
    }
}
