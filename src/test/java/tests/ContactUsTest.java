package tests;

import com.shaft.driver.SHAFT;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.io.IOException;

public class ContactUsTest extends TestBase {
    HomePage homePage;
    ContactUsPage contactUsPage;
    SHAFT.TestData.JSON contactUsData;
    String currentTime  = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToContactUsPage(){
        homePage = new HomePage(driver);
        homePage.navigateToContactPage();
    }

    @Test(priority = 1)
    public void enterContactUsData() {
        contactUsPage = new ContactUsPage(driver);
        contactUsData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/contactUsData.json");
        contactUsPage.enterContactUsData(contactUsData.getTestData("name"),
                contactUsData.getTestData("email")+currentTime+"@gmail.com",
                contactUsData.getTestData("phone"), contactUsData.getTestData("comment"));

    }

    @Test(priority = 2)
    public void assertSendingMessageSuccessfully()  {
        contactUsPage = new ContactUsPage(driver);
        Assert.assertEquals(contactUsPage.getAssertionMessage()
                ,"Thanks for contacting us. We'll get back to you as soon as possible.");
    }
}
