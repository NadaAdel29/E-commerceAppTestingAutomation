package StepDefinition;

import Pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationStepDefinition {

    WebDriver driver = null;
    RegisterPage Register;
    @Before("@Register")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds
        //driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Register = new RegisterPage();
    }

    @And("user navigate to Register Page")
    public void Navigate_to_Register()
    {
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @When("user enter valid data")
    public void ValidData() throws InterruptedException {
        Thread.sleep(2000);
        Register.RegisterSteps(driver, "test", "test2", "test9068@gmail.com", "abcdef", "abcdef");
        Thread.sleep(2000);
    }

    @And("user click on Register button")
    public void click_on_Register() throws InterruptedException {
        Register.confirmPasswordPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(4000);

    }
    @Then("user could Register successfully")
    public void success_login()
    {
        String expectedResult = "Your registration completed";
        String ActualResult = driver.findElement(Register.Register()).getText();
        // JUnit
        Assert.assertTrue(ActualResult.contains(expectedResult));
        Assert.assertEquals(ActualResult.contains(expectedResult),true);
    }

    @And("user go to home page")
    public void home_page() throws InterruptedException {
        Assert.assertEquals("https://demo.nopcommerce.com/registerresult/1?returnUrl=/htc-one-m8-android-l-50-lollipop",driver.getCurrentUrl());
        System.out.println(" current url"+driver.getCurrentUrl());
        Thread.sleep(2000);
    }


    @After("@Register")
    public void closeBrowser() {
        driver.quit();
    }
}
