package StepDefinition;

import Pages.AddCompareListPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCompareListDefinition {
    WebDriver driver = null;
    AddCompareListPage Compare;
    @Before("@Compare")
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //2- new object of web driver
        driver = new ChromeDriver();
        //3- navigate to google website and maximize screen and sleep 3 seconds

        driver.manage().window().maximize();
        Thread.sleep(3000);
        Compare = new AddCompareListPage();

    }
    @And("user navigate to compare")
    public void userNavigate()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("choose item Compare")
    public void ValidData()
    {
        Compare.itemPOM(driver).click();
    }
    @And("user click on item Compare")
    public void ValidData2()
    {
        driver.findElement(By.className("add-to-compare-list-button")).click();
    }


    @And("user click on add compare")
    public void ClickOnadd() throws InterruptedException {
        //Wishlist.ItemPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String ActualResult= driver.findElement(Compare.Message()).getText();
        String ExpectedResult= "The product has been added to your product comparison";
        Assert.assertTrue( ActualResult.contains(ExpectedResult));
        Assert.assertEquals(ActualResult.contains(ExpectedResult),true);
        System.out.println("Actual Result is " + ActualResult);
        Thread.sleep(3000);
    }

    @Then("user go to home page message Compare")
    public void homePage()
    {
        Assert.assertEquals("https://demo.nopcommerce.com/htc-one-m8-android-l-50-lollipop",driver.getCurrentUrl());

    }


    @After("@Compare")
    public void Close()
    {
        driver.quit();
    }

}
