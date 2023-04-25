package computer;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends TopMenuTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        String menuName = "Computers";
        selectMenu(menuName);
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        List<WebElement> beforesortingelement = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
        List<String> beforesortingtext = new ArrayList<>();
        for (WebElement elements : beforesortingelement) {
            beforesortingtext.add(elements.getText());
        }
        clickOnElement(By.xpath("(//option[normalize-space()='Name: Z to A'])[1]"));
        Thread.sleep(1000);

        // Verify the Product will arrange in Descending order.
        List<WebElement> aftersortingelement = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
        List<String> aftersortingtext = new ArrayList<>();
        for (WebElement elements : aftersortingelement) {
            aftersortingtext.add(elements.getText());
        }
        Collections.sort(beforesortingtext);
        Collections.reverse(beforesortingtext);
        Assert.assertEquals(beforesortingtext, aftersortingtext);
    }


    @Test

    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // Click on computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));

        //Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//option[@value='5']"));

        // Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        Assert.assertEquals(actualMessage, expectedMessage);

        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropdown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //Select "8GB [+$60.00]" using Select class.
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_2"));
        selectByVisibleTextFromDropdown(By.id("product_attribute_2"), "8GB [+$60.00]");

        // Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_3_7"));
        sendTextToElement(By.id("product_attribute_3_7"), "400 GB [+$100.00]");

        // Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_4_9"));
        sendTextToElement(By.id("product_attribute_4_9"), "Vista Premium [+$60.00]");

        // Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_5_12"));

        // Verify the price "$1,475.00"
        String expectedAmount = "$1,475.00";
        String actualAmount = getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]"));
        Assert.assertEquals("Text is not present", expectedAmount, actualAmount);

        // Click on "ADD TO CARD" Button.
        Thread.sleep(1000);
        clickOnElement(By.xpath(" //button[@id='add-to-cart-button-1']"));

        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectMessage2 = "The product has been added to your shopping cart";
        String actualMessage2 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("Text is not present", expectMessage2, actualMessage2);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));

        // Verify the message "Shopping cart"
        String expectMessage3 = "Shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals("Text is not present", expectMessage3, actualMessage3);

        // Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.xpath("//input[@class='qty-input']"));
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        // Verify the Total"$2,950.00"
        String expectedAmount1 = "$2,950.00";
        String actualAmount1 = getTextFromElement(By.xpath("//span[contains(text(),'$2,950.00')]"));
        Assert.assertEquals("Text is not present", expectedAmount1, actualAmount1);

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        // Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        // Verify the Text “Welcome, Please Sign In!”
        String expectedAmount2 = "Welcome, Please Sign In!";
        String actualAmount2 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals("Message is not present", expectedAmount2, actualAmount2);

        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //Fill the all mandatory field
        //First Name
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "patel");
        Thread.sleep(1000);
        //LastName
        sendTextToElement(By.id("BillingNewAddress_LastName"), "King");
        Thread.sleep(1000);
        //Email
        sendTextToElement(By.id("BillingNewAddress_Email"), "patelkingno1@gmail.com");
        Thread.sleep(1000);
        //select country
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        selectByVisibleTextFromDropdown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        Thread.sleep(1000);
        //City
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        Thread.sleep(1000);
        //Address 1
        sendTextToElement(By.id("BillingNewAddress_Address1"), "123 Abcd");
        Thread.sleep(1000);
        //Address 2
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "12ab 34c");
        Thread.sleep(1000);
        //Phone Number
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "0123456789");
        Thread.sleep(1000);

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(1000);

        // Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));
        Thread.sleep(1000);

        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(1000);

        // Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@type='button' and @onclick='PaymentMethod.save()']"));
        Thread.sleep(1000);

        //Click on “CONTINUE”
        //  clickOnElement(By.xpath("//button[@type='button']]"));
        //clickOnElement(By.xpath("//button[@type='button']]"));


        //Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//select[@id='CreditCardType']"));
        selectByVisibleTextFromDropdown(By.id("CreditCardType"), "Master card");
        Thread.sleep(1000);

        // Fill all the details
        //Cardholder Name<option value="MasterCard" xpath="1">Master card</option>slot
        sendTextToElement(By.id("CardholderName"), "MR I M PATEL");
        Thread.sleep(1000);
        //Card Number
        sendTextToElement(By.id("CardNumber"), "0110 1231 1456 0110");
        Thread.sleep(1000);
        //Expiration Date
        clickOnElement(By.id("ExpireMonth"));
        selectByVisibleTextFromDropdown(By.id("ExpireMonth"), "06");
        Thread.sleep(1000);

        clickOnElement(By.id("ExpireYear"));
        selectByVisibleTextFromDropdown(By.id("ExpireYear"), "2024");
        Thread.sleep(1000);
        //Card Code
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        Thread.sleep(1000);

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(1000);

        //Verify “Payment Method” is “Credit Card”
        assertVerifyText(By.xpath("//span[contains(text(),'Payment Method:')]"), "Payment Method:");
        assertVerifyText(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");

        //Verify “Shipping Method” is “Next Day Air”
        assertVerifyText(By.xpath("//span[contains(text(),'Shipping Method:')]"), "Shipping Method:");
        assertVerifyText(By.xpath("//ul//li//span[contains(text(),'Next Day Air')]"), "Next Day Air");

        //Verify Total is “$2,950.00”
        assertVerifyText(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"), "$2,950.00");

        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //Verify the Text “Thank You”
        assertVerifyText(By.xpath("//h1[normalize-space()='Thank you']"), "Thank you");

        //Verify the message “Your order has been successfully processed!”
        assertVerifyText(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"),
                "Your order has been successfully processed!");

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //Verify the text “Welcome to our store”
        assertVerifyText(By.xpath("//h2[normalize-space()='Welcome to our store']"), "Welcome to our store");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
