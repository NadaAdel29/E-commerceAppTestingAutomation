package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchCurrenciesPage {
    public WebElement SwitchPOM(WebDriver driver)
    {
        return driver.findElement(By.id("customerCurrency"));
    }

    public void SwitchSteps(WebDriver driver,String Data)
    {
        SwitchPOM(driver).clear();
        SwitchPOM(driver).sendKeys(Data);


    }
}
