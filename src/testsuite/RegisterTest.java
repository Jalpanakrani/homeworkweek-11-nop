package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        // Find Register link and click on Register link
        WebElement Register= driver.findElement(By.className("ico-register"));
        Register.click();

        //This is from requirement
        String expectedMessage = "Register";

        // Find the welcome text element and get the text
        WebElement actuleMessageElement = driver.findElement(By.xpath("//a[contains(text(),'Register')]')]"));
        String actualMessage = actuleMessageElement.getText();
        // Validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }
    public void verifyUserShouldRegisterAccountSuccessfully(){
        // Find Register link and click on Register link
        WebElement Register= driver.findElement(By.className("ico-register"));
        Register.click();

        // click on gender radio button
        WebElement radiobutton= driver.findElement(By.xpath("//label[contains(text(),'Gender:')]"));
        radiobutton.click();
        // Enter First Name
        WebElement FirstNameField= driver.findElement(By.id("FirstName"));
        //  FirstName Field
        FirstNameField.sendKeys("Swaminarayan");
        FirstNameField.click();
        // Enter Last Name
        WebElement LastNameField= driver.findElement(By.name("LastName"));
        //  LastName Field
        LastNameField.sendKeys("Nilkanth");
        LastNameField.click();
        // Select day month and year
        WebElement DayMonthYearField= driver.findElement(By.id("DateOfBirthDay"));
        //  dayMonthYear Field
        DayMonthYearField.sendKeys("30");
        DayMonthYearField.click();
        // Enter Email Address
        WebElement EmailField= driver.findElement(By.id("Email"));
        //  Email address Field
        EmailField.sendKeys("nakranijalpa1987@gmail.com");
        EmailField.click();
        // Click on Password
        WebElement PasswordField= driver.findElement(By.id("Password"));
        //  Password Field
        PasswordField.sendKeys("patel123");
        PasswordField.click();
        // Click on ConfirmPassword
        WebElement ConfirmPasswordField= driver.findElement(By.id("Password"));
        //  ConfirmPassword Field
        PasswordField.sendKeys("patel123");
        PasswordField.click();
        // Click on REGISTERBUTTOn
        WebElement REGISTERBUTTOnField= driver.findElement(By.id("register-button"));
        //This is from requirement
        String expectedMessage = "REGISTER";

        // Find the REGISTER element and get the text
        WebElement actuleMessageElement = driver.findElement(By.xpath("//button[@id='register-button']"));
        String actualMessage = actuleMessageElement.getText();
        // Validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}



