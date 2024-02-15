package com.zebrunner.carina.demo.saucedemo.pages.desktop;

import com.zebrunner.carina.demo.saucedemo.components.BurgerMenu;
import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement burgerBtn;

    @FindBy(xpath = "//option[contains(.,'%s')]")
    private ExtendedWebElement universalDropdownMenu;

    @FindBy(xpath = "//div[@class='header_label']")
    private ExtendedWebElement header;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<ExtendedWebElement> priceItemText;

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    private List<ExtendedWebElement> listItemTitleText;

    @FindBy(xpath = "(//div[@class='inventory_item_name '])[%d]")
    private ExtendedWebElement itemTitleText;

    @FindBy(xpath = "//div[contains(text(),'%s')]/../../following-sibling::div/button[contains(@class,'btn_inventory')]")
    private ExtendedWebElement addToCartBtn;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private ExtendedWebElement cartItemCounter;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cartBtn;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement burgerMenuBtn;

    @FindBy(xpath = "//div[@class='bm-menu']")
    private BurgerMenu burgerMenu;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHeaderPresent() {
        return header.isPresent();
    }

    @Override
    public void clickAddToCartBtn(String productName) {
        addToCartBtn.format(productName).click();
    }
    @Override
    public void clickAddToCartBtnEnum(ProductName productName) {
        addToCartBtn.format(productName.getProductType()).click();
    }

    @Override
    public boolean isCounterItemsInCartPresent() {
        return cartItemCounter.isPresent();
    }

    @Override
    public CartPageBase clickOnCartBtn() {
        cartBtn.click();
        return initPage(driver, CartPageBase.class);
    }

    @Override
    public void clickOnBurgerMenu() {
        burgerMenuBtn.click();
    }

    @Override
    public BurgerMenu getBurgerMenu() {
        return burgerMenu;
    }
}
