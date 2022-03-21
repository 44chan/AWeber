package com.AWeber.pages;

import com.AWeber.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@data-tip-target='me']")
    public WebElement MyProfileImgBtn;

    public void clickMyProfileImgBtn(){

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(MyProfileImgBtn).click().perform();

        //MyProfileImgBtn.click();
    }

}
