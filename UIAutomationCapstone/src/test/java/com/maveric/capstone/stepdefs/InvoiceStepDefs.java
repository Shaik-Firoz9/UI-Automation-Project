package com.maveric.capstone.stepdefs;

import com.maveric.capstone.databeans.CheckOutBean;
import com.maveric.capstone.pagebeans.InvoicePageBean;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class InvoiceStepDefs {
    private InvoicePageBean pageBean ;

    @Before
    public  void setupScenarioEnv(){
        pageBean =  new InvoicePageBean();
    }

    @DataTableType
    public CheckOutBean acceptUserInputData(Map<String,String> inputData) {
        CheckOutBean checkOutBean = new CheckOutBean();
        checkOutBean.setFirstName(inputData.get("firstName"));
        checkOutBean.setLastName(inputData.get("lastName"));
        checkOutBean.setPostalCode(inputData.get("postalCode"));
        return checkOutBean;
    }
    @Given("User is already logged in and navigated to the product page")
    public void user_is_already_logged_in_and_navigated_to_the_product_page() {
        pageBean.openProductsPage();

    }

    @When("User selects the desired products and adds them to the cart")
    public void user_selects_the_desired_products_and_adds_them_to_the_cart() {
        pageBean.addToCartProduct1();
        pageBean.addToCartProduct2();
        pageBean.addToCartProduct3();

    }

    @When("User clicks on the Cart button")
    public void user_clicks_on_the_cart_button() {
        pageBean.cartIcon();

    }

    @Then("User should navigate to the your cart page and see all the selected products")
    public void user_should_navigate_to_the_your_cart_page_and_see_all_the_selected_products() {
        String expectedMsg="Your Cart";
        String actualMsg=pageBean.getYourCartItems();
        Assert.assertEquals(expectedMsg,actualMsg);

    }

    @When("User clicks the Checkout button")
    public void user_clicks_the_checkout_button() {
        pageBean.checkOutBtn();

    }

    @Then("User should be navigated to the checkout information page")
    public void user_should_be_navigated_to_the_checkout_information_page() {
        String expectedMsg="Checkout: Your Information";
        String actualMsg=pageBean.getSucessfulMsg();
        Assert.assertEquals(expectedMsg,actualMsg);

    }

    @Then("User enters all the required data except for the first name and clicks on the CONTINUE button")
    public void user_enters_all_the_required_data_except_for_the_first_name_and_clicks_on_the_continue_button() {
        pageBean.setFirstName("");
        pageBean.setLastName("feroz");
        pageBean.setPostalCode("601301");
        pageBean.continueBtn();



    }

    @Then("Error: First Name is required message should be displayed on screeen")
    public void error_first_name_is_required_message_should_be_displayed_on_screeen() {
        String expectedMsg="Error: First Name is required";
        String actualMsg=pageBean.getErrorMsg();
        Assert.assertEquals(expectedMsg,actualMsg);

    }

    @Then("User enters all the required data except for the last name and clicks on the CONTINUE button")
    public void user_enters_all_the_required_data_except_for_the_last_name_and_clicks_on_the_continue_button() {
        pageBean.setFirstName("feroz");
        pageBean.setLastName("");
        pageBean.setPostalCode("601301");
        pageBean.continueBtn();

    }

    @Then("Error: Last Name is required message should be displayed on screen")
    public void error_last_name_is_required_message_should_be_displayed_on_screen() {
        String expectedMsg="Error: Last Name is required";
        String actualMsg=pageBean.getErrorMsg();
        Assert.assertEquals(expectedMsg,actualMsg);

    }

    @Then("User enters all the required data except for the postal code and clicks on the CONTINUE button")
    public void user_enters_all_the_required_data_except_for_the_postal_code_and_clicks_on_the_continue_button() {
        pageBean.setFirstName("shaik");
        pageBean.setLastName("feroz");
        pageBean.setPostalCode("");
        pageBean.continueBtn();

    }

    @Then("Error: Postal Code is required message should be displayed on screen")
    public void error_postal_code_is_required_message_should_be_displayed_on_screen() {
        String expectedMsg="Error: Postal Code is required";
        String actualMsg=pageBean.getErrorMsg();
        Assert.assertEquals(expectedMsg,actualMsg);

    }



    @Then("User enters the following details and clicks on the CONTINUE button")
    public void user_enters_the_following_details_and_clicks_on_the_continue_button(CheckOutBean checkOutBean) {
        pageBean.setFirstName(checkOutBean.getFirstName());
        pageBean.setLastName(checkOutBean.getLastName());
        pageBean.setPostalCode(checkOutBean.getPostalCode());
        pageBean.continueBtn();


    }

    @Then("User should navigate to the checkout overview page")
    public void user_should_navigate_to_the_checkout_overview_page() {
        String expectedMsg="Checkout: Overview";
        String actualMsg=pageBean.getSucessfulMsg();
        Assert.assertEquals(expectedMsg,actualMsg);

    }

    @When("User captures the SauceCard and total amount")
    public void user_captures_the_sauce_card_and_total_amount() {
        System.out.println(pageBean.getSauceCard());
        System.out.println(pageBean.getItemTotalPayment());
        System.out.println(pageBean.getTotalPayment());
        String expected=pageBean.getTotalPrice();
        String actual=pageBean.getItemTotalPayment();
        Assert.assertEquals(expected,actual);

    }

    @When("User clicks the FINISH button")
    public void user_clicks_the_finish_button() {
        pageBean.finishBtn();

    }

    @Then("User should be navigated to the order completion page")
    public void user_should_be_navigated_to_the_order_completion_page() {
        String expected="THANK YOU FOR YOUR ORDER";
        String actual=pageBean.getOrderConfirmMsg();
        Assert.assertEquals(expected,actual);

    }
    @After
    public void tearDownScenarioEnv() {

        pageBean.close();

    }


}
