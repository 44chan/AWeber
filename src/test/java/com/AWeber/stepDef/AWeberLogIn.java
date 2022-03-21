package com.AWeber.stepDef;

import com.AWeber.pages.LoginPage;
import com.AWeber.utils.BrowserUtil;
import com.AWeber.utils.ConfigReader;
import com.AWeber.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AWeberLogIn {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.getToLoginPage();
    }

        @When("user log-in")
        public void user_log_in() {
            loginPage.logIn(ConfigReader.read("login"),ConfigReader.read("password"));

        }

    @Then("user should be able to log-in to the {string}")
    public void user_should_be_able_to_log_in_to_the(String expectedTitle) {

        BrowserUtil.waitFor(1);

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }

}
