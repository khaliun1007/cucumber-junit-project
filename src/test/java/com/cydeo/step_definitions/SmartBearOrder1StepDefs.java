package com.cydeo.step_definitions;

import com.cydeo.pages.SmartBearBasePage;
import com.cydeo.pages.SmartBearPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class SmartBearOrder1StepDefs {

    SmartBearPage smartBearPage = new SmartBearPage();
    SmartBearBasePage smartBearBasePage = new SmartBearBasePage();


    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page(Map<String, String> credentials) {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbear.url"));
        smartBearPage.login(credentials.get("username"), credentials.get("password"));

        smartBearBasePage.orderPage.click();

    }
    @When("User fills out the form as followed:")
    public void user_fills_out_the_form_as_followed() {
    }

    @When("User selects FamilyAlbum from product dropdown")
    public void user_selects_family_album_from_product_dropdown() {
        Select dropDown= new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        dropDown.selectByValue("FamilyAlbum");

    }
    @When("User enters {string} to quantity")
    public void user_enters_to_quantity(String count) {
        smartBearPage.quantityBox.clear();
        smartBearPage.quantityBox.sendKeys(count);
    }
    @When("User enters {string} to costumer name")
    public void user_enters_to_costumer_name(String name) {
        smartBearPage.customerName.sendKeys(name);
    }

    @When("User enters {string} to street")
    public void user_enters_to_street(String street) {
        smartBearPage.street.sendKeys(street);
    }

    @When("User enters {string} to city")
    public void user_enters_to_city(String city) {
        smartBearPage.city.sendKeys(city);
    }

    @When("User enters {string} to state")
    public void user_enters_to_state(String state) {
        smartBearPage.state.sendKeys(state);
    }

    @When("User enters {string}")
    public void user_enters(String zip) {
        smartBearPage.zip.sendKeys(zip);
    }

    @When("User selects Visa as card type")
    public void user_selects_visa_as_card_type() {
        smartBearPage.cardType.click();
    }

    @When("User enters {string} to card number")
    public void user_enters_to_card_number(String cardNumber) {
        smartBearPage.cardNumber.sendKeys(cardNumber);
    }

    @When("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String expireDate) {
        smartBearPage.expireDate.sendKeys(expireDate);
    }

    @When("User clicks process button")
    public void user_clicks_process_button() {
        smartBearPage.processBtn.click();
    }

    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String expectedName) {
        smartBearBasePage.viewAllOrdersPage.click();

        Assert.assertEquals("order Verification is failed", Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//td[.='John Wick']")).getText(), expectedName);

    }

}
