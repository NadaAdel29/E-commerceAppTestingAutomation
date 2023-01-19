package StepDefinition;

import Pages.DifferentTagsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferentTagsDefinition {
    WebDriver driver = null;
    DifferentTagsPage Tags;
    @Before("@Tags")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
        Tags= new DifferentTagsPage();

    }


    @And("user navigate to Tags")
    public void user_navigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("choose Tags")
    public void ValidData()
    {
        //  Filter.FilterSteps(driver, "Grey");
        driver.findElement(By.cssSelector("a[href=\"/computers\"]")).click();
        Tags.TagsPOM(driver).click();
        //driver.findElement(By.cssSelector("a[href=\"/desktops\"]")).click();
    }
//    @And("choose subcategory")
//    public void ValidData2()
//    {
//        Tags.TagsPOM(driver).click();
//
//        //driver.findElement(By.cssSelector("a[href=\"/desktops\"]")).click();
//    }


    @And("user click on Tags button")
    public void login_button() throws InterruptedException {
        Tags.TagsPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }



    @Then("user go to home page with Tags")
    public void homePage()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/apparel-2",driver.getCurrentUrl());

    }

    @After("@Tags")
    public void close_browser()
    {
        driver.quit();
    }


}
