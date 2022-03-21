package com.AWeber.pages;

import com.AWeber.utils.BrowserUtil;
import com.AWeber.utils.ConfigReader;
import com.AWeber.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='usernameOrEmail']")
    public WebElement loginField;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[.='Continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//button[.='Log In']")
    public WebElement logInBtn;


    public void logIn(String userName,String password){
        loginField.sendKeys(userName);
        continueBtn.click();
        BrowserUtil.waitFor(1);
        passwordField.sendKeys(password);
        logInBtn.click();
    }

    public void getToLoginPage(){
        Driver.getDriver().get(ConfigReader.read("LogInURL"));
    }

}
