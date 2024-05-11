package tests;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    protected SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void setDriver(){
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.theworldfootballstore.com/");
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
