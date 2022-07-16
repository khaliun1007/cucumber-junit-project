package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VytrackBasePage {

    public VytrackBasePage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='title title-level-1']")
    public List<WebElement> allModules;

    @FindBy(css = "#user-menu>a")
    public WebElement username;

    @FindBy(xpath = "//a[@href='javascript: void(0);']")
    public WebElement logout_dropdown;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logout_button;

    public void vyTrack_logout() {
        logout_dropdown.click();
        logout_button.click();
    }
}



