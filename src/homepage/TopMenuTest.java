package homepage;

import browserstesting.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='" + menu + "']"));
    }

    @Test
    public void verifyPageNavigation() {
        String menuname = "Gift Cards";
        String expectedMessage = "Gift Cards";
        selectMenu(menuname);
        String actualMsg = getTextFromElement(By.xpath("//h1"));
        verifyToElement(expectedMessage, actualMsg);
    }
}
