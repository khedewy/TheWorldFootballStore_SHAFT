package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class ContactUsPage {
    private final SHAFT.GUI.WebDriver driver;
    public ContactUsPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }


    private final By nameTxt = By.id("ContactName");
    private final By emailTxt =  By.id("ContactEmail");
    private final By phoneTxt = By.id("ContactNumber");
    private final By commentTxt = By.id("ContactForm-body");
    private final By sendMessageButton = By.xpath("//button[@class='button med-btn btn-block icon-btn right-icon style2']");
    private final By assertionMessage = By.xpath("//*[@id=\"ContactForm\"]/div[5]/p");

    public void enterContactUsData(String name, String email, String phone, String comment){
        driver.element().type(nameTxt,name);
        driver.element().type(emailTxt,email);
        driver.element().type(phoneTxt,phone);
        driver.element().type(commentTxt,comment);
        driver.element().click(sendMessageButton);
    }

    public String getAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }


}
