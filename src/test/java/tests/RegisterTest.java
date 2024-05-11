package tests;

import com.shaft.driver.SHAFT;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;



public class RegisterTest extends TestBase {
   HomePage homePage;
   SHAFT.TestData.JSON registerData;
   RegisterPage registerPage;
   String currentTime = String.valueOf(System.currentTimeMillis());
   WebDriverWait wait;
    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData() throws InterruptedException {
        registerPage = new RegisterPage(driver);
       registerData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/registerData.json");
        registerPage.enterRegisterData(registerData.getTestData("firstName"),
                registerData.getTestData("lastName"),
                registerData.getTestData("email")+currentTime+"@gmail.com",registerData.getTestData("password"));
    }

    @Test(priority = 2)
    public void navigateToAccountManager(){
        registerPage = new RegisterPage(driver);
        registerPage.navigateToAccountManager();
    }

    @Test(priority = 3)
    public void assertRegistering(){
        registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.getAssertionMessage(),"Mahmoud Khedwewy\n" +
                "Egypt");
    }

}
