package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductWishlistPage {
    public WebElement ItemPOM(WebDriver driver)
    {
        return driver.findElement(By.cssSelector("a[href=\"/htc-one-m8-android-l-50-lollipop\"]"));
    }

    public By Message()
    {
        return By.className("content");
    }
    public void wishlistSteps(WebDriver driver,String Item)
    {
        ItemPOM(driver).clear();
        ItemPOM(driver).sendKeys(Item);


    }

}
