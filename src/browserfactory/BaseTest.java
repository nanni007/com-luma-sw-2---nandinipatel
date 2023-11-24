package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {
    //this class is parent class
//properties of this class will be inherited by the child classes
// it provides the different browsers user wants to use
    static String browser = "Chrome";
    public static WebDriver driver;

    public void openBrowser(String baseUrl) { //using if else for the user to chose browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver(); //opens chrome browser
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver(); //opens edge browser
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();  //opens firefox browser
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();  //opens safari browser
        } else if (browser.equalsIgnoreCase("Internet Explorer")) {
            driver = new InternetExplorerDriver();  //opens internet explorer
        } else {
            System.out.println("Enter correct browser name...");
        }
        driver.get(baseUrl); //opens the url
        driver.manage().window().maximize();  //maximises the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //wait time for 5 seconds
    }

    public void closeBrowser() {
        driver.quit();  // closes the browser
    }
}
