package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductCartPage {
    public WebElement ItemsPOM(WebDriver driver)
    {
        return driver.findElement(By.cssSelector("a[href=\"/htc-one-m8-android-l-50-lollipop\"]"));
    }

    public By Message()
    {
        return By.className("content");
    }
    public void cardSteps(WebDriver driver,String Item)
    {
        ItemsPOM(driver).clear();
        ItemsPOM(driver).sendKeys(Item);


    }
}
