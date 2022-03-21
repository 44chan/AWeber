package com.AWeber.pages;

import com.AWeber.utils.BrowserUtil;
import com.AWeber.utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

    Actions actions = new Actions(Driver.getDriver());

    public MyProfilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "first_name")
    public WebElement FirstNameField;

    @FindBy(id = "last_name")
    public WebElement LastNameField;

    @FindBy(xpath = "//button[.='Save profile details']")
    public WebElement SaveChangesBtn;

    @FindBy(xpath = "//div[@id='notices']")
    public WebElement SuccessTextPopUpNotice;

    @FindBy(xpath = "//button[@aria-label='Dismiss']")
    public WebElement CloseSuccessTextPopUpNoticeBtn;

    @FindBy(xpath = "//button[.='Add']")
    public WebElement AddBtn;

    @FindBy(xpath = "//button[.='Add URL']")
    public WebElement AddURLBtn;

    @FindBy(xpath = "//div//fieldset[@class='profile-links-add-other__fieldset form-fieldset']//input[contains(@value,'')][1]")
    public WebElement EnterURLBtn;

    @FindBy(xpath = "//div//fieldset[@class='profile-links-add-other__fieldset form-fieldset']//input[contains(@value,'')][2]")
    public WebElement EnterDescriptionBtn;

    @FindBy(xpath = "//span[@class='profile-link__title']")
    public WebElement NewURLElement;

    @FindBy(xpath = "//button[.='Add Site']")
    public WebElement AddSiteBtn;

    @FindBy(xpath = "//button[@class='button profile-link__remove is-borderless']")
    public WebElement DeleteLink;


    public void updateFirstLastName(String firstName, String lastName){

        FirstNameField.click();
        FirstNameField.clear();
        FirstNameField.sendKeys(firstName);
        LastNameField.click();
        LastNameField.clear();
        LastNameField.sendKeys(lastName);

    }

    public void saveChangesBtnClick(){
        SaveChangesBtn.click();
    }

    public void CloseSuccessTextPopUpNoticeBtn(){
        CloseSuccessTextPopUpNoticeBtn.click();
    }

    public String getPopUpTextInProfile(){
        return SuccessTextPopUpNotice.getText();
    }

    public void clickAddBtn(){
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(AddBtn).click().perform();
    }

    public void clickAddURLBtn(){
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(AddURLBtn).click().perform();
    }

    public void clickAddSiteBtn(){
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(AddSiteBtn).click().perform();
    }

    public void clickDeleteLink(){
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(DeleteLink).click().perform();
    }

    public String getNewURLElementText(){
        return NewURLElement.getText();
    }

    public void enterUrlAndDecr(String URL,String desc){

        BrowserUtil.waitFor(1);
        clickAddURLBtn();

        BrowserUtil.waitFor(1);
        EnterURLBtn.click();
        EnterURLBtn.sendKeys(URL);

        BrowserUtil.waitFor(1);
        EnterDescriptionBtn.click();
        EnterDescriptionBtn.sendKeys(desc);


    }

}
