package StepDefinition;

import Pages.AddProductWishlistPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductWishlistDefinition {
    WebDriver driver = null;
    AddProductWishlistPage Wishlist;
    @Before("@Wishlist")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
        Wishlist = new AddProductWishlistPage();

    }
    @And("user navigate to wishlist")
    public void userNavigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("choose item")
    public void ValidData()
    {
        Wishlist.ItemPOM(driver).click();
    }
    @When("user click on item")
    public void ValidData2()
    {
        driver.findElement(By.id("add-to-wishlist-button-18")).click();
    }


    @And("user click on add")
    public void ClickOnReset() throws InterruptedException {
        //Wishlist.ItemPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String ActualResult= driver.findElement(Wishlist.Message()).getText();
        String ExpectedResult= "The product has been added to your wishlist";
        Assert.assertTrue( ActualResult.contains(ExpectedResult));
        Assert.assertEquals(ActualResult.contains(ExpectedResult),true);
        System.out.println("Actual Result is " + ActualResult);
        Thread.sleep(3000);
    }

    @Then("user go to home page message")
    public void homePage()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/htc-one-m8-android-l-50-lollipop",driver.getCurrentUrl());

    }


    @After("@Wishlist")
    public void Close()
    {
        driver.quit();
    }
}
