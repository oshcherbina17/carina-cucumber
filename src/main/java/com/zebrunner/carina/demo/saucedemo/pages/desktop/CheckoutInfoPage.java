package com.zebrunner.carina.demo.saucedemo.pages.desktop;

import com.zebrunner.carina.demo.ConnectionFactory;
import com.zebrunner.carina.demo.db.mappers.UserMapper;
import com.zebrunner.carina.demo.db.models.User;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.ibatis.session.SqlSession;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutInfoPageBase.class)
public class CheckoutInfoPage extends CheckoutInfoPageBase {

    @FindBy(xpath = "//input[@id='first-name']")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//input[@id='postal-code']")
    private ExtendedWebElement postalCodeInput;

    @FindBy(xpath = "//input[@id='continue']")
    private ExtendedWebElement continueBtn;

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeInformation(String username) {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findByUserName(username);
            firstNameInput.type(user.getFirstName());
            lastNameInput.type(user.getLastName());
            postalCodeInput.type(user.getZip().toString());
        }
    }

    @Override
    public void typeUserInformation(String firstName, String lastName, String zip) {
            firstNameInput.type(firstName);
            lastNameInput.type(lastName);
            postalCodeInput.type(zip);

    }

    @Override
    public CheckoutOverviewPageBase clickOnContinueBtn() {
        continueBtn.click();
        return initPage(driver, CheckoutOverviewPageBase.class);
    }

}
