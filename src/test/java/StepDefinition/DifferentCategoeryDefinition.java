package StepDefinition;

import Pages.DifferentCategoeryPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferentCategoeryDefinition {
    WebDriver driver = null;
    DifferentCategoeryPage Category;
    @Before("@Category")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
       Category= new DifferentCategoeryPage();

    }


    @And("user navigate to category")
    public void user_navigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("choose Category")
    public void ValidData()
    {
        //  Filter.FilterSteps(driver, "Grey");
        driver.findElement(By.cssSelector("a[href=\"/computers\"]")).click();
        //driver.findElement(By.cssSelector("a[href=\"/desktops\"]")).click();
    }
    @And("choose subcategory")
    public void ValidData2()
    {
        Category.CategoryPOM(driver).click();

        //driver.findElement(By.cssSelector("a[href=\"/desktops\"]")).click();
    }


//    @And("user click on Category button")
//    public void login_button() throws InterruptedException {
//        Category.CategoryPOM(driver).sendKeys(Keys.ENTER);
//        Thread.sleep(3000);
//    }



    @Then("user go to home page with category")
    public void homePage()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/desktops",driver.getCurrentUrl());

    }

    @After("@Category")
    public void close_browser()
    {
        driver.quit();
    }


}
