package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DifferentCategoeryPage {
    public WebElement CategoryPOM(WebDriver driver)

    {
        return driver.findElement(By.cssSelector("a[href=\"/desktops\"]"));
    }

    public void CategorySteps(WebDriver driver,String Data)
    {
        CategoryPOM(driver).clear();
        CategoryPOM(driver).sendKeys(Data);


    }
}


