package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DifferentTagsPage {
    public WebElement TagsPOM(WebDriver driver)

    {
        return driver.findElement(By.cssSelector("a[href=\"/apparel-2\"]"));
    }

    public void TagsSteps(WebDriver driver,String Data)
    {
        TagsPOM(driver).clear();
        TagsPOM(driver).sendKeys(Data);


    }
}
