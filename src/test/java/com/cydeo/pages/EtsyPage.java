package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyPage {

    public EtsyPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id="global-enhancements-search-query")
    public WebElement searchBox;

    @FindBy (xpath="//span[@class='wt-icon wt-nudge-b-2 wt-nudge-r-1']")
    public WebElement searchBtn;




}
