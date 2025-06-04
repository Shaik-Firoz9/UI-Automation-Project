package com.maveric.capstone.pagebeans;

import com.maveric.capstone.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePageBean {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
    private WebElement addToCartProduct1;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")
    private WebElement addToCartProduct2;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button")
    private WebElement addToCartProduct3;
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private WebElement cartIcon;
    @FindBy(xpath = "//*[@id=\"contents_wrapper\"]/div[2]")
    private WebElement sucessfulMsg;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]")
    private WebElement sauceCard;
    @FindBy(className = "summary_total_label")
    private WebElement totalPayment;
    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotalPayment;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")
    private WebElement finishBtn;
    @FindBy(className = "complete-header")
    private WebElement orderConfirmMsg;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy (id = "last-name")
    private WebElement lastName;

    @FindBy (id = "postal-code")
    private  WebElement postalCode;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")
    private WebElement checkOutBtn;
    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")
    private WebElement continueBtn;
    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/h3")
    private WebElement errorMsg;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]")
    private WebElement firstProductPrice;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]")
    private WebElement secondProductPrice;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[5]/div[2]/div[2]")
    private WebElement thirdProductPrice;




    public InvoicePageBean(){
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void openProductsPage(){
        driver.get("https://www.saucedemo.com/v1/inventory.html");
    }

    public  void addToCartProduct1(){
        this.addToCartProduct1.click();
    }
    public  void addToCartProduct2(){
        this.addToCartProduct2.click();
    }
    public  void addToCartProduct3(){
        this.addToCartProduct3.click();
    }
    public  void cartIcon(){
        this.cartIcon.click();
    }
    public String getYourCartItems(){
        return this.sucessfulMsg.getText();
    }



    public void openCheckOutPage(){
        driver.get("https://www.saucedemo.com/v1/cart.html");
    }

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }
    public void setPostalCode(String postalCode){
        this.postalCode.sendKeys(postalCode);
    }
    public void checkOutBtn(){
        this.checkOutBtn.click();
    }
    public void continueBtn(){
        this.continueBtn.click();
    }
    public String getSucessfulMsg(){
        return this.sucessfulMsg.getText();
    }

    public String getErrorMsg(){
        return this.errorMsg.getText();
    }






    public void openBillingPage(){
        driver.get("https://www.saucedemo.com/v1/checkout-step-two.html");
    }


    public String getSauceCard(){
        return this.sauceCard.getText();
    }
    public String getTotalPayment(){
        return this.totalPayment.getText();
    }
    public String getItemTotalPayment(){
        return this.itemTotalPayment.getText();
    }
    public void finishBtn(){
        this.finishBtn.click();
    }

    public String getOrderConfirmMsg(){
        return this.orderConfirmMsg.getText();
    }


    public String getFirstProductPrice(){
        return this.firstProductPrice.getText();
    }
    public String getSecondProductPrice(){
        return this.secondProductPrice.getText();
    }
    public String getThirdProductPrice(){
        return this.thirdProductPrice.getText();
    }
//    public double getTotalPrice(){
//        double firstProductPrice=Double.parseDouble(this.getFirstProductPrice());
//        double secondProductPrice=Double.parseDouble(this.getSecondProductPrice());
//        double thirdProductPrice=Double.parseDouble(this.getThirdProductPrice());
//        double sumOfItems=firstProductPrice+secondProductPrice+thirdProductPrice;
//
//        return sumOfItems;
//
//    }
public String getTotalPrice(){

    double firstProductPrice=Double.parseDouble(this.getFirstProductPrice().replace("$",""));
    double secondProductPrice=Double.parseDouble(this.getSecondProductPrice().replace("$",""));
    double thirdProductPrice=Double.parseDouble(this.getThirdProductPrice().replace("$",""));
    double sum=firstProductPrice+secondProductPrice+thirdProductPrice;
    String sumOfItems="Item total: "+"$"+String.valueOf(sum);

    return sumOfItems;

}
//    public String getTotalPrice() {
//        double firstProductPrice = Double.parseDouble(this.getFirstProductPrice().replace("$", ""));
//        double secondProductPrice = Double.parseDouble(this.getSecondProductPrice().replace("$", ""));
//        double thirdProductPrice = Double.parseDouble(this.getThirdProductPrice().replace("$", ""));
//
//        double sum = firstProductPrice + secondProductPrice + thirdProductPrice;
//        String sumOfItems = "$" + String.format("%.2f", sum); // Format to 2 decimal places
//
//        return sumOfItems;
//    }


    public void close(){
        driver.close();
    }






}
