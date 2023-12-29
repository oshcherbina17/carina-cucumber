package com.zebrunner.carina.demo.saucedemo.pages.desktop;

import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<ExtendedWebElement> itemTitleText;

    @FindBy(xpath = "//button[@id='checkout']")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public int getItemsListSize(){
       return itemTitleText.size();
    }

    @Override
    public CheckoutInfoPageBase clickOnCheckoutInfoBtn() {
        checkoutBtn.click();
        return initPage(driver, CheckoutInfoPageBase.class);
    }
}
