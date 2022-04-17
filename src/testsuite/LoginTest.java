package testsuite;

import browserfactory.BaseTest;
import graphql.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //find login link and click on Login link
        WebElement loginlink = driver.findElement(By.linkText("Log in"));
        loginlink.click();
        //This is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        //find the welcome,please Sign In text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);
        //validate actual and expected message

        //  Assert.asserts("Not navigate to login page",expectedMessage,actualMessage);
    }

@Test
public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
    //find login link and click on Login link
    WebElement loginlink = driver.findElement(By.linkText("Log in"));
    loginlink.click();
    //Enter valid username
    WebElement username = driver.findElement(By.id("Email"));
    //sending field valid username
    username.sendKeys("nakranijalpa1987@gmail.com");

    // Find the invalid password field element
    WebElement passwordField = driver.findElement(By.name("Password"));
    //     Sending invalid Password to password field element
    passwordField.sendKeys("jalpa123");


    //Find the login button and click on it
    WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
    loginButton.click();

    //This is from requirement
    String expectedMessage = "Log out";

    //find the log out text element and get the text
    WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
    String actualMessage = actualMessageElement.getText();
    System.out.println(actualMessage);
    //validate actual and expected message

}
    @Test
    public void verifyTheErrorMessage() {
        //find login link and click on Login link
        WebElement loginlink = driver.findElement(By.linkText("Log in"));
        loginlink.click();
        //Enter invalid username
        WebElement username = driver.findElement(By.id("Email"));
        //sending field invalid username
        username.sendKeys("nakranijalpa19@gmail.com");

        // Find the invalid password field element
        WebElement passwordField = driver.findElement(By.name("Password"));
        //     Sending invalid Password to password field element
        passwordField.sendKeys("jalpa");

        //Find the login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        loginButton.click();
        //This is from requirement
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        //find the welcome,please Sign In text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);
        //validate actual and expected message
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}

