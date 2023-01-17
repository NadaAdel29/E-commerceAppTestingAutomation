package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    public WebElement FirstNamePOM(WebDriver driver)
    {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement LastNamePOM(WebDriver driver)
    {
        return driver.findElement(By.id("LastName"));
    }

    public WebElement EmailPom(WebDriver driver)
    {
        return driver.findElement(By.id("Email"));
    }
    public WebElement passwordPOM(WebDriver driver)
    {

        return driver.findElement(By.name("Password"));
    }
    public WebElement confirmPasswordPOM(WebDriver driver)
    {

        return driver.findElement(By.name("ConfirmPassword"));
    }

 //login.passwordPOM(driver).sendKeys(Keys.ENTER);
    public By Register()
    {
        return By.cssSelector("button[type=\"submit\"]");
    }

    public void RegisterSteps(WebDriver driver,String FirstName, String lastName,String Email, String password, String confirmPassword)

    {
        FirstNamePOM(driver).clear();
        FirstNamePOM(driver).sendKeys(FirstName);
        LastNamePOM(driver).sendKeys(lastName);
        EmailPom(driver).sendKeys(Email);
        passwordPOM(driver).sendKeys(password);
        confirmPasswordPOM(driver).sendKeys(confirmPassword);


    }

}
