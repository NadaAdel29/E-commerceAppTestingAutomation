package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    public WebElement SearchPOM(WebDriver driver)
    {
        return driver.findElement(By.id("small-searchterms"));
    }


    public void SearchSteps(WebDriver driver,String Data)
    {
       SearchPOM(driver).clear();
        SearchPOM(driver).sendKeys(Data);


    }
}
