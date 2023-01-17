package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebElement EmailPOM(WebDriver driver)
    {
        return driver.findElement(By.id("Email"));
    }

    public WebElement passwordPOM(WebDriver driver)
    {

        return driver.findElement(By.name("Password"));
    }


    public void loginSteps(WebDriver driver,String Email, String password)
    {
        EmailPOM(driver).clear();
        EmailPOM(driver).sendKeys(Email);
        passwordPOM(driver).sendKeys(password);

    }
}

