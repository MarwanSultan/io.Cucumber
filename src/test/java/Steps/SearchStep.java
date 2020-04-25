package Steps;

import Core.src.test.java.base.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AmazonHome;

public class SearchStep extends BaseTest {

  AmazonHome amazonHome;

  @Before
  public void initialize(Scenario scenario) {
    System.out.println("------------------------------");
    System.out.println("Starting - " + scenario.getName());
    System.out.println("------------------------------");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.amazon.com");
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
    AmazonHome amazonHome = new AmazonHome(driver);
    amazonHome.initialize();
    driver.manage().window().maximize();
  }

  @Given("^I am on the home page$")
  public void iAmOnTheHomePage() {
    AmazonHome amazonHome = new AmazonHome(driver);
    String actualTitle = driver.getTitle();
    String expectedTitle =
        "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    Assert.assertEquals(expectedTitle, actualTitle);
  }

  @Then("^I enter and search an item name in the search field$")
  public void iEnterAndSearchAnItemNameInTheSearchField() {
    AmazonHome amazonHome = new AmazonHome(driver);
    amazonHome.searchFeature("Alexa");
  }

  @And("^The matching results will be displayed$")
  public void theMatchingResultsWillBeDisplayed() {
    AmazonHome amazonHome = new AmazonHome(driver);
    amazonHome.validateProductSearch();
  }

  @After
  public void tearDown(Scenario scenario) {
    System.out.println("------------------------------");
    System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
    System.out.println("------------------------------");
      driver.quit();

    }
  }

