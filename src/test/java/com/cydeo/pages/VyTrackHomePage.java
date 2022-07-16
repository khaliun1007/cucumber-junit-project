package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackHomePage extends VytrackBasePage{

    public VyTrackHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id= "prependedInput")
    public WebElement userNameBox;

    @FindBy (id="prependedInput2")
    public WebElement passwordBox;

    @FindBy(id="_submit")
    public WebElement loginBtn;


    public void loginVyTrack(String userName, String password){
        userNameBox.sendKeys(userName);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }

    @FindBy (linkText = "Vehicles")
    public WebElement vehiclesBtn;

    @FindBy (xpath = "//a[@title='With this button you will export the content of the grid as it appears to you, with filters and sorting applied. All pages will be exported.']")
    public  WebElement exportGridDropdown;

    @FindBy(xpath = "//a[@title='CSV']")
    public WebElement expGridDrop1;

    @FindBy(xpath = "//a[@title='XLSX']")
    public WebElement expGridDrop2;

    @FindBy(xpath = "//a[@title='Reset']")
    public WebElement resetBtn;

    @FindBy(xpath = "//a[@title='Refresh']")
    public WebElement refreshBtn;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement gridDropdown;

    @FindBy (xpath = "//div[@class='loader-frame']")
    public WebElement loader;

    @FindBy (xpath = "//div[@class='loader-mask']")
    public WebElement resetLoader;


}
