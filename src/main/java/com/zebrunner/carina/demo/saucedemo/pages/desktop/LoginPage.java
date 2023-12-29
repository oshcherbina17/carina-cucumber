package com.zebrunner.carina.demo.saucedemo.pages.desktop;

import com.zebrunner.carina.demo.saucedemo.pages.common.HomePageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    @FindBy(xpath = "//input[@id='user-name']")
    private ExtendedWebElement userNameInputField;

    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement passwordInputField;

    @FindBy(xpath = "//input[@id='login-button']")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase login(String userName, String password) {
        userNameInputField.type(userName);
        passwordInputField.type(password);
        loginBtn.click();
        return initPage(driver, HomePageBase.class);
    }

}
