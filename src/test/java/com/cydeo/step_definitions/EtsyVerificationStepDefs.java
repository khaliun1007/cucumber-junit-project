package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyVerificationStepDefs {

    EtsyPage etsyPage= new EtsyPage();


    @Given("User is on etsy home page")
    public void user_is_on_etsy_home_page() {
        Driver.getDriver().get("https://www.etsy.com ");
    }
    @Then("user sees expected title")
    public void user_sees_expected_title() {
        Assert.assertEquals("Etsy title verification is failed", "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", Driver.getDriver().getTitle());
    }

    @When("User types Wooden Spoon in the search box")
    public void userTypesWoodenSpoonInTheSearchBox() {
        etsyPage.searchBox.sendKeys("Wooden Spoon");
    }

    @When("User clicks search button")
    public void userClicksSearchButton() {
        etsyPage.searchBtn.click();
    }

    @Then("User sees Wooden Spoon is in the title")
    public void userSeesWoodenSpoonIsInTheTitle() {
        Assert.assertEquals("Title verification is failed",  "Wooden spoon - Etsy",Driver.getDriver().getTitle());

    }

    @When("User types {string} in the search box")
    public void userTypesInTheSearchBox(String searchKeyword) {
        etsyPage.searchBox.sendKeys(searchKeyword);
    }

    @Then("User sees {string} is in the title")
    public void userSeesIsInTheTitle(String expectedTitle) {
        Assert.assertEquals("Title verification is failed", expectedTitle, Driver.getDriver().getTitle());
    }
}
