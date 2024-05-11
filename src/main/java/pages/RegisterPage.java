package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class RegisterPage {
    private final SHAFT.GUI.WebDriver driver;

    public RegisterPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By firstNameTxt = By.id("Customerfirst_name");
    private final By lastNameTxt = By.id("Customer-last_name");
    private final By emailTxt = By.id("Customer-email");
    private final By passwordTxt = By.id("Customer-password");
    private final By registerButton = By.xpath("//button[@class='button med-btn btn-block icon-btn right-icon style2']");
    private final By accountManager = By.xpath("//a[@class='unstyled-link header__icons-link account']");
    private final By AssertionMessage = By.xpath("//p[text()='Mahmoud Khedwewy']");

    public void enterRegisterData(String firstName, String lastName, String email , String password) throws InterruptedException {
        driver.element().type(firstNameTxt,firstName);
        driver.element().type(lastNameTxt,lastName);
        driver.element().type(emailTxt,email);
        driver.element().type(passwordTxt,password);
        driver.element().click(registerButton);
    }

    public void navigateToAccountManager(){
        driver.element().click(accountManager);
    }

    public String getAssertionMessage(){
        return  driver.element().getText(AssertionMessage);
    }

}
