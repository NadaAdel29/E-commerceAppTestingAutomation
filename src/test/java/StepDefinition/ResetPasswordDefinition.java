package StepDefinition;

import Pages.ResetPasswordPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResetPasswordDefinition {
    WebDriver driver = null;
    ResetPasswordPage Reset;
    @Before("@Reset")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
        Reset = new ResetPasswordPage();

    }
    @And("user navigate to Reset Password Page")
    public void userNavigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/passwordrecovery");
    }

    @When("user enter valid Email")
    public void ValidData()
    {
        Reset.ResetPasswordStep(driver, "nada1@gmail.com");
    }

    @And("user click on Recover")
    public void ClickOnReset() throws InterruptedException {
            Reset.EmailPOM(driver).sendKeys(Keys.ENTER);
            Thread.sleep(3000);
        String ActualResult= driver.findElement(Reset.Message()).getText();
        String ExpectedResult= "Email with instructions has been sent to you.";
        Assert.assertTrue( ActualResult.contains(ExpectedResult));
        Assert.assertEquals(ActualResult.contains(ExpectedResult),true);
        System.out.println("Actual Result is " + ActualResult);
        Thread.sleep(3000);
    }

    @After("@Reset")
    public void Close()
    {
        driver.quit();
    }
}
