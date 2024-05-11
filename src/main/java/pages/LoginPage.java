package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final SHAFT.GUI.WebDriver driver;
    public LoginPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By logoutButton = By.xpath("//a[@class='unstyled-link button xsmall-btn icon-btn right-icon style2']");
    private final By IconManager = By.xpath("//a[@title='Log in']");
    private final By emailTxt = By.id("CustomerEmail");
    private final By passwordTxt = By.id("CustomerPassword");
    private final By loginButton = By.xpath("//*[@id=\"customer_login\"]/button");
    private final By AssertionMessage = By.xpath("//p[text()='Mahmoud Khedwewy']");


    public void logoutAndNavigateToLoginPage(){
        driver.element().click(logoutButton);
        driver.element().click(IconManager);
    }

    public void enterLoginData(String email,String password){
        driver.element().type(emailTxt,email);
        driver.element().type(passwordTxt,password);
        driver.element().click(loginButton);
    }
    public String getAssertionMessage(){
        return  driver.element().getText(AssertionMessage);
    }



}
