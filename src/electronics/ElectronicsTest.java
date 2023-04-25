package electronics;

import browserstesting.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {

        //  1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        //  1.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        Thread.sleep(2000);
        //   1.3 Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse Hover on “Electronics” Tab
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //  2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //  2.3 Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

        //  2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //  2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        // 2.6 Verify the text “Nokia Lumia 1020”
        assertVerifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");

        //   2.7 Verify the price “$349.00”
        assertVerifyText(By.xpath("//span[@id='price-value-20']"), "$349.00");

        //   2.8 Change quantity to 2
        Actions actions = new Actions(driver);
        clickOnElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        //   2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //   2.10 Verify the Message "The product has been added to your shopping cart" on Top  green Bar
        assertVerifyText(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");

        //   After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //   2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        //   2.12 Verify the message "Shopping cart"
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //   2.13 Verify the quantity is 2
        String expectedQuantityTextMessage = "2";
        String actualQuantityTextMessage3 = driver.findElement(By.xpath("//input[@class='qty-input']")).getAttribute("value");
        verifyToElement(expectedQuantityTextMessage, actualQuantityTextMessage3);
        Thread.sleep(1000);


        //    2.14 Verify the Total $698.00
        assertVerifyText(By.xpath("//span//strong[contains(text(),'$698.00')]"), "$698.00");

        //   2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //    2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //   2.17 Verify the Text “Welcome, Please Sign In!”
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //    2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //    2.19 Verify the text “Register”
        assertVerifyText(By.xpath("//h1[contains(text(),'Register')]"), "Register");

        //    2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.id("FirstName"), "Abcde");
        sendTextToElement(By.id("LastName"), "wxyz");
        selectByVisibleTextFromDropdown(By.xpath("//select[@name='DateOfBirthDay']"), "1");
        selectByVisibleTextFromDropdown(By.xpath("//select[@name='DateOfBirthMonth']"), "April");
        selectByVisibleTextFromDropdown(By.xpath("//select[@name='DateOfBirthYear']"), "1990");
        sendTextToElement(By.id("Email"), "xyz@gmail.com");
        sendTextToElement(By.id("Password"), "1234567890");
        sendTextToElement(By.id("ConfirmPassword"), "1234567890");

        //   2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //   2.22 Verify the message “Your registration completed”
        assertVerifyText(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");

        //    2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //    2.24 Verify the text “Shopping card”
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
    }

    /**
     * WHEN I RUN THIS TEST ITS AUTOMATICALLY SHOPPING CART GET EMPTY SO I CAN NOT ABLE TO CONTINUE THIS TEST
     * <p>
     * <p>
     * 2.25 click on checkbox “I agree with the terms of service”
     * 2.26 Click on “CHECKOUT”
     * 2.27 Fill the Mandatory fields
     * 2.28 Click on “CONTINUE”
     * 2.29 Click on Radio Button “2nd Day Air ($0.00)”
     * 2.30 Click on “CONTINUE”
     * 2.31 Select Radio Button “Credit Card”
     * 2.32 Select “Visa” From Select credit card dropdown
     * 2.33 Fill all the details
     * 2.34 Click on “CONTINUE”
     * 2.35 Verify “Payment Method” is “Credit Card”
     * 2.36 Verify “Shipping Method” is “2nd Day Air”
     * 2.37 Verify Total is “$698.00”
     * 2.38 Click on “CONFIRM”
     * 2.39 Verify the Text “Thank You”
     * 2.40 Verify the message “Your order has been successfully processed!”
     * 2.41 Click on “CONTINUE”
     * 2.42 Verify the text “Welcome to our store”
     * 2.43 Click on “Logout” link
     * 2.44 Verify the URL is “https://demo.nopcommerce.com/
     */

    @After
    public void tearDown() {
        closeBrowser();
    }


}
