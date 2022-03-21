package com.AWeber.stepDef;

import com.AWeber.pages.MainPage;
import com.AWeber.pages.MyProfilePage;
import com.AWeber.utils.BrowserUtil;
import com.AWeber.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AWeberMyProfile {

    MainPage mainPage = new MainPage();
    MyProfilePage myProfilePage = new MyProfilePage();

    @When("user click My Profile button")
    public void user_click_my_profile_button() {
        BrowserUtil.waitFor(1);
        mainPage.clickMyProfileImgBtn();
    }
    @Then("user is on the {string} page")
    public void user_is_on_the_page(String expectedTitle) {

        BrowserUtil.waitFor(1);

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Given("user is on the My Profile page")
    public void user_is_on_the_my_profile_page() {
        BrowserUtil.waitFor(1);
        mainPage.clickMyProfileImgBtn();
    }

    @When("user update first name to {string} and last name to {string}")
    public void user_update_first_name_to_and_last_name_to(String firstName, String lastName) {

        myProfilePage.updateFirstLastName(firstName,lastName);

    }

    @When("user submit changes with Save profile details button")
    public void user_submit_changes_with_save_profile_details_button() {

        myProfilePage.saveChangesBtnClick();

    }
    @Then("user verify that changes was successful by seeing popup text {string}")
    public void user_verify_that_changes_was_successful_by_seeing_popup_text(String expectedResult) {
        String actualResult = myProfilePage.getPopUpTextInProfile();

        Assert.assertEquals(expectedResult,actualResult);

        myProfilePage.CloseSuccessTextPopUpNoticeBtn();
    }

    @When("user click Add button and click add URL button")
    public void user_click_add_button_and_click_add_url_button() {
        myProfilePage.clickAddBtn();
        BrowserUtil.waitFor(1);
    }
    @When("user add URL {string} and description {string} to the fields")
    public void user_add_url_and_description_to_the_fields(String url, String description) {
        myProfilePage.enterUrlAndDecr(url,description);
    }
    @When("user click Add Site button")
    public void user_click_add_site_button() {
        myProfilePage.clickAddSiteBtn();
    }
    @Then("user verify that changes was successful by seeing description {string}")
    public void user_verify_that_changes_was_successful_by_seeing_description(String expectedDescription) {

        String actualDescription = myProfilePage.getNewURLElementText();

        Assert.assertEquals(expectedDescription,actualDescription);

        BrowserUtil.waitFor(5);
        System.out.println("This will give you time to observe my GitLink (just in case))");
        myProfilePage.clickDeleteLink();

    }


}
