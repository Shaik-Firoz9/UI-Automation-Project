package com.maveric.capstone.stepdefs;
import com.maveric.capstone.databeans.UserBean;
import com.maveric.capstone.pagebeans.LoginPageBean;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Map;

public class LoginStepDefs {
    private LoginPageBean pageBean ;

    @Before
    public  void setupScenarioEnv(){
        pageBean =  new LoginPageBean();
    }

    @DataTableType
    public UserBean acceptUserInputData(Map<String,String>inputData){
        UserBean userBean = new UserBean();
        userBean.setUserName(inputData.get("userName"));
        userBean.setPassword(inputData.get("password"));
        return userBean;
    }

    @Given("User is on the Login page")
    public void user_is_on_the_login_page() {
        pageBean.openLoginPage();

    }

    @When("User enters only the username but leaves the password field empty")
    public void user_enters_only_the_username_but_leaves_the_password_field_empty() {
        pageBean.setUserName("standard_user");
        pageBean.setPassword("");

    }

    @When("clicks on Login")
    public void clicks_on_login() {
        pageBean.submit();

    }

    @Then("Epic sadface: Password is required message should display")
    public void epic_sadface_password_is_required_message_should_display() {
        String expectedErrorMsg ="Epic sadface: Password is required";
        String actualErrorMsg = pageBean.getErrorMsg();
        Assert.assertEquals(expectedErrorMsg,actualErrorMsg);

    }

    @When("User enters only the password but leaves the username field empty")
    public void user_enters_only_the_password_but_leaves_the_username_field_empty() {
        pageBean.setUserName("");
        pageBean.setPassword("secret_sauce");
    }

    @Then("Epic sadface: Username is required message should display")
    public void epic_sadface_username_is_required_message_should_display() {
        String expectedErrorMsg ="Epic sadface: Username is required";
        String actualErrorMsg = pageBean.getErrorMsg();
        Assert.assertEquals(expectedErrorMsg,actualErrorMsg);

    }

    @When("User enters a wrong username but correct password")
    public void user_enters_a_wrong_username_but_correct_password(UserBean userBean) {
        pageBean.setUserName(userBean.getUserName());
        pageBean.setPassword(userBean.getPassword());

    }

    @Then("Epic sadface: Username and password do not match any user in this service message should display")
    public void epic_sadface_username_and_password_do_not_match_any_user_in_this_service_message_should_display() {
        String expectedErrorMsg ="Epic sadface: Username and password do not match any user in this service";
        String actualErrorMsg = pageBean.getErrorMsg();
        Assert.assertEquals(expectedErrorMsg,actualErrorMsg);

    }

    @When("User enters the correct username but the wrong password")
    public void user_enters_the_correct_username_but_the_wrong_password(UserBean userBean) {
        pageBean.setUserName(userBean.getUserName());
        pageBean.setPassword(userBean.getPassword());

    }

    @When("User enters the correct username and password")
    public void user_enters_the_correct_username_and_password(UserBean userBean) {
        pageBean.setUserName(userBean.getUserName());
        pageBean.setPassword(userBean.getPassword());

    }

    @Then("User should successfully login")
    public void user_should_successfully_login() {
        String expectedMsg="Products";
        String actualMsg=pageBean.getSuccessMsg();
        Assert.assertEquals(expectedMsg,actualMsg);

    }
    @After
    public void tearDownScenarioEnv() {

        pageBean.closeLoginPage();
    }



}
