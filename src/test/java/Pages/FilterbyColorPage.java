package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterbyColorPage {
    public WebElement FilterPOM(WebDriver driver)
    {
        return driver.findElement(By.id("attribute-option-14"));
    }

    public void FilterSteps(WebDriver driver,String Data)
    {
        FilterPOM(driver).clear();
        FilterPOM(driver).sendKeys(Data);


    }
}
