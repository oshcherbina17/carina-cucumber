package com.zebrunner.carina.demo.saucedemo.pages.desktop;

import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.OrderCompletionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase {
    @FindBy(xpath = "//div[contains(@class,'summary_total_label')]")
    private ExtendedWebElement totalPrice;

    @FindBy(xpath = "//button[@id='finish']")
    private ExtendedWebElement finishBtn;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTotalPricePresent() {
        return totalPrice.isPresent();
    }

    @Override
    public OrderCompletionPageBase clickOnFinishBtn() {
        finishBtn.click();
        return initPage(driver, OrderCompletionPageBase.class);
    }
}
