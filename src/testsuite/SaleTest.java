package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void VerifyTheTotalItemsDisplayedOnTheWomenJacketsPage() {
        driver.findElement(By.xpath("")).click();  //finds the sign in button and clicks
        driver.findElement(By.name("login[username]")).sendKeys("xyz123@gmail.com");  //finds the email field and sends id address
        driver.findElement(By.name("login[password]")).sendKeys("xyz789");  //finds the email field and sends id address
        driver.findElement(By.xpath("//button[@id='send2' and @class='action login primary']")).click();
        driver.findElement(By.xpath("login-button")).click();  //finds the sign in button and clicks
        driver.findElement(By.id("ui-id-8")).click();  //finds the sales button and clicks


        driver.findElement(By.xpath("login-button")).click();  //finds the jacket button and clicks
        String expectedText = "Jackets";
        WebElement actualTextElement = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[1]/a"));  //finds the element and verify if actual and expected match
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text Error", expectedText, actualText); //compares if expected and actual is equal

        List<WebElement> itemsElements = driver.findElements(By.tagName("items"));

        System.out.println("Number of items = " + itemsElements.size());

        for ( WebElement items : itemsElements ) {
            System.out.println(items.getAttribute("href"));
            System.out.println(items.getText());
        }
        List<WebElement>displayingItems = driver.findElements(By.id("limiter-options"));
        System.out.println("Displaying items are: "  + displayingItems.size());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
