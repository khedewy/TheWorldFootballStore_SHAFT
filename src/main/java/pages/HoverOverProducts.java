package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class HoverOverProducts {
    private final SHAFT.GUI.WebDriver driver;
    public HoverOverProducts(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By MensProduct = By.xpath("//*[@id=\"shopify-section-sections--17069026738405__header\"]/header/div/div/ul[1]/li[2]/a");
    private final By topsProduct =  By.xpath("//a[@href='/collections/mens-tops']");
    private final By menAssertionsMessage = By.xpath("//h2[text()='Mens Tops']");
    private final By kidsProducts = By.xpath("//*[@id=\"shopify-section-sections--17069026738405__header\"]/header/div/div/ul[1]/li[4]/a");
    private final By accessoriesProducts = By.xpath("//a[@href='/collections/kids-accessories']");
    private final By accessoriesAssertionMessage = By.xpath("//h2[text()='Kids Accessories']");

    public void HoverOverMenProducts(){
      driver.element().hover(MensProduct).click(topsProduct);
    }

    public String getMenAssertionsMessage(){
        return driver.element().getText(menAssertionsMessage);
    }

    public void HoverOverKidsProducts(){
        driver.element().hover(kidsProducts).click(accessoriesProducts);

    }

    public String getKidsAccessoriesAssertionMessage(){
        return driver.element().getText(accessoriesAssertionMessage);
    }
}
