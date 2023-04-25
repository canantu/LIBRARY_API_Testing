package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page_Canan {

    public Home_Page_Canan(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@id='navbarDropdown']//span")
    public WebElement userNameLink;


}
