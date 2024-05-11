package tests;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;


public class LoginTest extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    SHAFT.TestData.JSON registerData;
    String currentTime = String.valueOf(System.currentTimeMillis());

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

    @Test(priority = 4)
    public void logout(){
        loginPage = new LoginPage(driver);
        loginPage.logoutAndNavigateToLoginPage();
    }

    @Test(priority = 5)
    public void enterLoginData() {
        loginPage = new LoginPage(driver);
        loginPage.enterLoginData(registerData.getTestData("email")+currentTime+"@gmail",registerData.getTestData("password"));
        Assert.assertEquals(loginPage.getAssertionMessage(),"Mahmoud Khedwewy\n" +
                "Egypt");
    }

}
