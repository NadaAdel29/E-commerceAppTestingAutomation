package StepDefinition;

import Pages.AddProductCartPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductCartDefinition {
    WebDriver driver = null;
    AddProductCartPage Card;
    @Before("@Card")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
        Card = new AddProductCartPage();

    }
    @And("user navigate to Card")
    public void userNavigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("choose item card")
    public void ValidData()
    {
        Card.ItemsPOM(driver).click();
    }
    @And("user click on item card")
    public void ValidData2()
    {
        driver.findElement(By.id("add-to-cart-button-18")).click();
    }


    @And("user click on add card")
    public void ClickOnReset() throws InterruptedException {
        //Wishlist.ItemPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String ActualResult= driver.findElement(Card.Message()).getText();
        String ExpectedResult= "The product has been added to your shopping cart";
        Assert.assertTrue( ActualResult.contains(ExpectedResult));
        Assert.assertEquals(ActualResult.contains(ExpectedResult),true);
        System.out.println("Actual Result is " + ActualResult);
        Thread.sleep(3000);
    }

    @Then("user go to home page message card")
    public void homePage()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/htc-one-m8-android-l-50-lollipop",driver.getCurrentUrl());

    }


    @After("@Card")
    public void Close()
    {
        driver.quit();
    }
}
