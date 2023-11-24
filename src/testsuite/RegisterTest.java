package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void VerifyThatSignInPageDisplay() {
        driver.findElement(By.xpath("//div//li//a[text()='Create an Account']")).click();  //finds the create account button and clicks
        String expectedText = "Create New Customer Account";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1//span"));  //finds the element and verify if actual and expected match
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text Error", expectedText, actualText); //compares if expected and actual is equal
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        driver.findElement(By.xpath("//div//li//a[text()='Create an Account']")).click();  //finds the create account button and clicks
        driver.findElement(By.name("firstname")).sendKeys("uuttvv");  //finding the Firstname field element and sending name
        driver.findElement(By.id("lastname")).sendKeys("wwxxyy");  //finding the Lastname field element and sending name
        driver.findElement(By.id("email_address")).sendKeys("zzz123@gmail.com");  //finding the Email field element and sending address
        driver.findElement(By.id("password")).sendKeys("utvwxyz1234");//finding the Password field element and sending password
        driver.findElement(By.name("password_confirmation")).sendKeys("utvwxyz1234"); //finding the confirm password field element and sending address
        driver.findElement(By.className("action submit primary")).click(); //finding the Create an Account element and clicking


        String expectedText = "Thank you for registering with Main Website Store";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store')]"));  //finds the element and verify if actual and expected match
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text Error", expectedText, actualText); //compares if expected and actual is equal

        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click(); //finding the Dropdown arrow element and clicking
        driver.findElement(By.className("action submit primary")).click(); //finding the Sign out element and clicking

        String signOutExpectedText = "You are signed out";
        WebElement signOutActualTextElement = driver.findElement(By.xpath("//span[@class='base']"));  //finds the element and verify if actual and expected match
        String signOutActualText = actualTextElement.getText();
        Assert.assertEquals("Text Error", signOutExpectedText,signOutActualText); //compares if expected and actual is equal
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}