package StepDefinition;

import Pages.SuccessOrderPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuccessOrderDefinition
{
    WebDriver driver = null;
    SuccessOrderPage Order;
    @Before("@Order")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
        Order = new SuccessOrderPage();

    }
    @And("user navigate to order")
    public void userNavigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("choose item Order")
    public void ValidData()
    {
        Order.itemsPOM(driver).click();
    }
    @And("user click on item Order")
    public void ValidData2()
    {
        driver.findElement(By.id("add-to-cart-button-18")).click();
    }


//    @And("user click on add Order")
//    public void ClickOnReset() throws InterruptedException {
//        //Wishlist.ItemPOM(driver).sendKeys(Keys.ENTER);
////        Thread.sleep(3000);
////        String ActualResult= driver.findElement(Card.Message()).getText();
////        String ExpectedResult= "The product has been added to your shopping cart";
////        Assert.assertTrue( ActualResult.contains(ExpectedResult));
////        Assert.assertEquals(ActualResult.contains(ExpectedResult),true);
////        System.out.println("Actual Result is " + ActualResult);
//
//        Assert.assertEquals("https://demo.nopcommerce.com/cart",driver.getCurrentUrl());
//        Thread.sleep(3000);
//    }

    @And ("click on card")
    public void cardPage()
    {
        driver.findElement(By.id("topcartlink")).click();
    }
    @And ("click on terms")
    public void terms()
    {
        driver.findElement(By.id("termsofservice")).click();
    }
    @And ("click on checkout")
    public void checkout()
    {
        driver.findElement(By.id("checkout")).click();
    }
    @Then("user go to home page message Order")
    public void homePage() throws InterruptedException {
        Assert.assertEquals("https://demo.nopcommerce.com/cart",driver.getCurrentUrl());
        Thread.sleep(3000);

    }


    @After("@Order")
    public void Close()
    {
        driver.quit();
    }
}
