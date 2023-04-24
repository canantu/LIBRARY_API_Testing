package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Environment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Canan {

    public Login_Page_Canan(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInButton;

    public void loginAsRole(String role){

        String email, password;

        switch (role) {

            case "student":
                email = Environment.STUDENT_EMAIL;
                password = Environment.STUDENT_PASSWORD;
                break;
            case "librarian":
                email = Environment.LIBRARIAN_EMAIL;
                password = Environment.LIBRARIAN_PASSWORD;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + role);
        }
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        signInButton.click();
    }

}
