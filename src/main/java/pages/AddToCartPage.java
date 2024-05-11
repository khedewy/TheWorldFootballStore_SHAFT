package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AddToCartPage {
    private final SHAFT.GUI.WebDriver driver;
    public AddToCartPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By size = By.xpath("//*[@id=\"option-2-3-template--17069030801637__main\"]");
    private final By quantityBox = By.name("quantity");
    private final By addToCartButton = By.xpath("//button[@class='atc__button button btn-block style2']");
    private final By viewCartPage = By.xpath("//a[@class='continue-btn hyperlink text-small']");
    private final By AssertionMessage = By.xpath("//a[text()='Official Arsenal Polo - Red']");

    public void addProductToCart(String quantity) {
        driver.element().click(size);
        driver.element().clear(quantityBox);
        driver.element().type(quantityBox,quantity);
        driver.element().click(addToCartButton);
        driver.element().click(viewCartPage);
    }

    public String getAssertionMessage(){
        return driver.element().getText(AssertionMessage);
    }


}
