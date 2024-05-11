package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final SHAFT.GUI.WebDriver driver;
    WebDriverWait wait;
    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By accountManagerIcon = By.xpath("//a[@class='unstyled-link header__icons-link account']");
    private final By createAccountButton = By.xpath("//*[@id=\"customer_login\"]/div[3]/p/a");
    private final By acceptCookies = By.xpath("//button[text()='Accept']");
    private final By searchIcon = By.xpath("//a[@class='unstyled-link header__icons-link search']");
    private final By searchBox = By.id("Search-In-Template");
    private final By searchButton = By.xpath("//button[@class='mg-search-button seachbar__button']");
    private final By contactUsButton = By.xpath("//a[@class='unstyled-link footer-menu-head text-small with-link']");

    public RegisterPage navigateToRegisterPage(){
        driver.element().click(acceptCookies);
        driver.element().click(accountManagerIcon);
        driver.element().click(createAccountButton);
        return new RegisterPage(driver);
    }

    public SearchPage searchForItems(String product){
        driver.element().click(searchIcon);
        driver.element().type(searchBox,product);
        driver.element().click(searchButton);
        return new SearchPage(driver);
    }

    public ContactUsPage navigateToContactPage(){
        driver.element().click(acceptCookies);
        driver.element().click(contactUsButton);
        return new ContactUsPage(driver);
    }
}
