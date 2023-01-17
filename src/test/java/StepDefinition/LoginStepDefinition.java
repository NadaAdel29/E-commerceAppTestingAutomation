package StepDefinition;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {
    WebDriver driver = null;
    LoginPage login;
    @Before("@Selenium")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
        login=new LoginPage();

    }


    @And("user navigate to login page")
    public void user_navigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    @When("user enter valid data login")
    public void ValidData()
    {
        login.loginSteps(driver, "nada1@gmail.com","abcdef");
    }


    @And("user click on login button")
    public void login_button() throws InterruptedException {
        login.passwordPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }



    @Then("user go to home page login")
    public void homePage()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/",driver.getCurrentUrl());

    }



    @After("@Selenium")
    public void close_browser()
    {
        driver.quit();
    }
}


