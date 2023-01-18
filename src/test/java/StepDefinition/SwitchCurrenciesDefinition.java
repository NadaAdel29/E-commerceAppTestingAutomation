package StepDefinition;

import Pages.SwitchCurrenciesPage;
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



public class SwitchCurrenciesDefinition {

    WebDriver driver = null;
    SwitchCurrenciesPage Switch;
    @Before("@Switch")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
        Switch=new SwitchCurrenciesPage();

    }


    @And("user navigate to switch")
    public void user_navigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("switch the currencies")
    public void ValidData()
    {
        //Switch.SwitchSteps(driver, "US Dollar");
        driver.findElement(By.id("customerCurrency")).click();
    }


    @And("user click on currency button")
    public void login_button() throws InterruptedException {
        Switch.SwitchPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }



    @Then("user go to home page with switch")
    public void homePage()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/search?q=Camera",driver.getCurrentUrl());

    }

    @After("@Switch")
    public void close_browser()
    {
        driver.quit();
    }


}
