package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearPage extends SmartBearBasePage {
    public SmartBearPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id= "ctl00_MainContent_username")
    public WebElement userNameBox;

    @FindBy (id= "ctl00_MainContent_password")
    public WebElement passwordBox;

    @FindBy (id = "ctl00_MainContent_login_button")
    public WebElement loginBtn;

    public void login (String username, String password){
        userNameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }

    @FindBy (id="ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBox;

    @FindBy (id="ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;

    @FindBy (id="ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy (id="ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;

    @FindBy (id="ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement cardType;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDate;

    @FindBy (id="ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processBtn;



}
