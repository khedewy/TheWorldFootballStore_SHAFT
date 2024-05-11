package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class SearchPage {
    private final SHAFT.GUI.WebDriver driver;
    public SearchPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By acceptCookies = By.xpath("//button[text()='Accept']");
    private final By searchPageAssertionMessage = By.xpath("//h3[text()='Search results']");
    private final By chosenProduct = By.xpath("//a[@title='Official Arsenal Polo - Red']");

    public String gegSearchPageAssertionMessage(){
        return driver.element().getText(searchPageAssertionMessage);
    }

    public void navigateToChosenProduct(){
        driver.element().click(acceptCookies);
        driver.element().click(chosenProduct);
    }
}
