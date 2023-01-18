package StepDefinition;

import Pages.LoginPage;
import Pages.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchDefinition {

    WebDriver driver = null;
    SearchPage Search;
    @Before("@Search")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
        Search=new SearchPage();

    }


    @And("user navigate to search")
    public void user_navigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("user enter valid data to search")
    public void ValidData()
    {
        Search.SearchSteps(driver, "Camera");
    }


    @And("user click on search button")
    public void login_button() throws InterruptedException {
        Search.SearchPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }



    @Then("user go to search page")
    public void homePage()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/search?q=Camera",driver.getCurrentUrl());

    }

    @After("@Search")
    public void close_browser()
    {
        driver.quit();
    }


}
