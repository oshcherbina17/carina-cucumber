package com.zebrunner.carina.demo.saucedemo.pages.desktop;

import com.zebrunner.carina.demo.saucedemo.pages.common.OrderCompletionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = OrderCompletionPageBase.class)
public class OrderCompletionPage extends OrderCompletionPageBase {

    @FindBy(xpath = "//h2[@class='complete-header']")
    private ExtendedWebElement titleComplete;

    @FindBy(xpath = "//div[@class='complete-text']")
    private ExtendedWebElement textComplete;

    public OrderCompletionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCompleteTitlePresent() {
        return titleComplete.isPresent();
    }

    @Override
    public boolean isCompleteTextPresent() {
        return titleComplete.isPresent();
    }
}
