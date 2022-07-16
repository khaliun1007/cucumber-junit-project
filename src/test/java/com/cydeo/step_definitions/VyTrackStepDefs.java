package com.cydeo.step_definitions;

import com.cydeo.pages.VyTrackHomePage;
import com.cydeo.pages.VytrackBasePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class VyTrackStepDefs {


    //Vytrack login test

    VyTrackHomePage vyTrackHomePage = new VyTrackHomePage();
    VytrackBasePage vytrackBasePage = new VytrackBasePage();
    Actions actions =new Actions(Driver.getDriver());

    @Given("User is already logged in Vytrack and on all cars page")
    public void user_is_already_logged_in_vytrack_and_on_all_cars_page() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack"));
        vyTrackHomePage.loginVyTrack(ConfigurationReader.getProperty("vytrack.username"), ConfigurationReader.getProperty("vytrack.password"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 1000);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        Assert.assertEquals("Login test is failed", "Dashboard", Driver.getDriver().getTitle() );

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        for (WebElement each : vytrackBasePage.allModules){
            Thread.sleep(1000);
//            Driver.getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
            if (each.getText().equals("Fleet")){
                Driver.getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
                each.click();
                wait.until(ExpectedConditions.elementToBeClickable(vyTrackHomePage.vehiclesBtn));
                actions.click(vyTrackHomePage.vehiclesBtn).perform();
            }
        }
        wait.until(ExpectedConditions.titleContains("All - Car"));
        Assert.assertEquals("Vehicles page title verification is failed", "All - Car - Entities - System - Car - Entities - System", Driver.getDriver().getTitle());

    }


    //Export grid dropdown test

    @When("User moves to the left of the page I'd see Export grid dropdown")
    public void user_moves_to_the_left_of_the_page_i_d_see_export_grid_dropdown() {
        actions.moveByOffset(1000, 100).moveToElement(vyTrackHomePage.exportGridDropdown).perform();
        Assert.assertTrue("Export Grid dropdown test is failed", vyTrackHomePage.exportGridDropdown.isDisplayed());

    }
    @When("User click the dropdown")
    public void user_click_the_dropdown() {
        vyTrackHomePage.exportGridDropdown.click();
    }
    @Then("User sees {int} options and can select them")
    public void user_sees_options_and_can_select_them(Integer int1) {

        Assert.assertTrue("dropdown test is failed", vyTrackHomePage.expGridDrop1.isDisplayed());
        Assert.assertTrue("dropdown test is failed", vyTrackHomePage.expGridDrop2.isDisplayed());
    }

//Refresh button test

    @When("User verifies that Refresh button is next to Reset button")
    public void user_verifies_that_refresh_button_is_next_to_reset_button()  {


    }


    @When("User clicks Refresh button")
    public void user_clicks_refresh_button()throws InterruptedException {
        actions.moveToElement(vyTrackHomePage.resetBtn).moveByOffset(50,50).click(vyTrackHomePage.refreshBtn).perform();

    }

    @Then("User sees page reloads")
    public void user_sees_page_reloads() {
        Assert.assertTrue("Refresh button test is failed", vyTrackHomePage.loader.isDisplayed());
    }


    @When("User verifies that Reset button is next to Grid setting button")
    public void userVerifiesThatResetButtonIsNextToGridSettingButton() {
    }

    @And("User clicks the Reset button")
    public void userClicksTheResetButton() {
    }

    @Then("User should see")
    public void userShouldSee() {
    }
}
