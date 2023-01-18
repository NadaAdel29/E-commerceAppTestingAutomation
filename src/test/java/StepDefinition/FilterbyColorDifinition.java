package StepDefinition;

import Pages.FilterbyColorPage;
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

public class FilterbyColorDifinition {
    WebDriver driver = null;
    FilterbyColorPage Filter;
    @Before("@Filter")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
        Filter= new FilterbyColorPage();

    }


    @And("user navigate to filter")
    public void user_navigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6");
    }

    @When("choose the color")
    public void ValidData()
    {
      //  Filter.FilterSteps(driver, "Grey");
        driver.findElement(By.className("attribute-square")).click();
    }


    @And("user click on color button")
    public void login_button() throws InterruptedException {
        Filter.FilterPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }



    @Then("user go to home page with filtration")
    public void homePage()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=14",driver.getCurrentUrl());

    }

    @After("@Filter")
    public void close_browser()
    {
        driver.quit();
    }


}
