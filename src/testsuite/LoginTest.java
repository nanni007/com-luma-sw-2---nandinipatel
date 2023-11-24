package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldloginSuccessfullyWithValidCredentials() {

        driver.findElement(By.xpath("")).click();  //finds the sign in button and clicks
        driver.findElement(By.name("login[username]")).sendKeys("xyz123456789@gmail.com");  //finds the email field and sends id address
        driver.findElement(By.name("login[password]")).sendKeys("zxcvbnm98.");  //finds the email field and sends id address
        driver.findElement(By.xpath("//button[@id='send2' and @class='action login primary']")).click();  //finds the sign in button and clicks

        String expectedText = "Welcome";
        WebElement actualTextElement = driver.findElement(By.className("logged-in"));  //finds the element and verify if actual and expected match
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text Error", expectedText, actualText); //compares if expected and actual is equal
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();  //finds the dropdown arrow button and clicks
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        driver.findElement(By.xpath("")).click();  //finds the sign in button and clicks
        driver.findElement(By.name("login[username]")).sendKeys("xyz123@gmail.com");  //finds the email field and sends id address
        driver.findElement(By.name("login[password]")).sendKeys("xyz789");  //finds the email field and sends id address
        driver.findElement(By.xpath("//button[@id='send2' and @class='action login primary']")).click();
        driver.findElement(By.xpath("login-button")).click();  //finds the sign in button and clicks
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.’";
        WebElement actualTextElement = driver.findElement(By.xpath("//button[contains(@class, 'register-button')]"));  //finds the element and verify if actual and expected match
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text Error", expectedText, actualText); //compares if expected and actual is equal
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        driver.findElement(By.xpath("")).click();  //finds the sign in button and clicks
        driver.findElement(By.name("login[username]")).sendKeys("xyz123456789@gmail.com");  //finds the email field and sends id address
        driver.findElement(By.name("login[password]")).sendKeys("zxcvbnm98.");  //finds the email field and sends id address
        driver.findElement(By.xpath("//button[@id='send2' and @class='action login primary']")).click();

        String expectedText = "Welcome";
        WebElement actualTextElement = driver.findElement(By.className("logged-in"));  //finds the element and verify if actual and expected match
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text Error", expectedText, actualText); //compares if expected and actual is equal
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();  //finds the dr

        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click(); //finds element to signout
        String signOutExpectedText = "You are signed out!";
        WebElement signOutActualTextElement = driver.findElement(By.xpath("//h1"));  //finds the element and verify if actual and expected match
        String signOutActualText = signOutActualTextElement.getText();
        Assert.assertEquals("Text Error", signOutExpectedText, signOutActualText); //compares if expected and actual is equal
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
