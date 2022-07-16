package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearBasePage {
    public SmartBearBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (linkText = "Order")
    public WebElement orderPage;

    @FindBy (linkText = "View all orders")
    public WebElement viewAllOrdersPage;
}
