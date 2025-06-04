package com.maveric.capstone.pagebeans;

import com.maveric.capstone.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageBean {
    private WebDriver driver;

    @FindBy(name = "user-name")
    private WebElement userName;

    @FindBy (name = "password")
    private WebElement password;

    @FindBy (id = "login-button")
    private  WebElement LoginBtn;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/form/h3")
    private WebElement errorMsg;


    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div[1]/div[3]/div")
    private WebElement successfullLoginMsg;

    public LoginPageBean(){
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void openLoginPage(){
        driver.get("https://www.saucedemo.com/v1/");
    }

    public void setUserName(String userName){
        this.userName.sendKeys(userName);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }
    public  void submit(){
        this.LoginBtn.click();
    }

    public  String getErrorMsg(){
        return  this.errorMsg.getText();
    }

    public String getSuccessMsg(){
        return this.successfullLoginMsg.getText();
    }

    public void closeLoginPage(){
        driver.close();
    }
}
