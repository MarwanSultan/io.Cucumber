package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AmazonHome extends BasePage {

  WebDriverWait wait;

  @FindBy(
      css =
          "#search > div.s-desktop-width-max.s-desktop-content.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(5) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(2) > div > span > div > div > div:nth-child(2) > div.sg-col-4-of-24.sg-col-4-of-12.sg-col-4-of-36.sg-col-4-of-28.sg-col-4-of-16.sg-col.sg-col-4-of-20.sg-col-4-of-32 > div > div > span > a > div > img")
  private WebElement firstSearchResult;

  @FindBy(id = "twotabsearchtextbox")
  private WebElement searchBox;

  @FindBy(css = "nav-link-accountList > span.nav-line-1")
  private WebElement searchButton;

  @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/span[1]")
  private WebElement signInLink;

  @FindBy(xpath = "//*[@id=\"nav-logo\"]/a[1]/span[1]")
  private WebElement tryPrimeLink;

  @FindBy(css = "#nav-orders > span.nav-line-2")
  private WebElement orderslink;

  @FindBy(id = "navFooter")
  private WebElement amazonFooter;

  @FindBy(id = "div#nav-logo")
  private WebElement amazonLogo;

  @FindBy(linkText = "Amazons Choice")
  private WebElement amazonsChoice;

  ///////////////////////////////////////////////
  public AmazonHome(WebDriver driver) {

    super(driver);
  }
  //////////////////////////////////////////////////

  // ----------------------------------------------------------------------------------

  /////////////////// METHODS//////////////////////////////////////////
  /**/
  public void resetAmazonHome() {
    tryPrimeLink.click();
  }

  public void initialize() {
    tryPrimeLink.isEnabled();
  }

  public void clickSignIn() {
    signInLink.click();
  }

  public void searchFeature(String var) {
    assertEquals(true, searchBox.isEnabled());
    searchBox.clear();

    searchBox.sendKeys(var);
    searchBox.sendKeys(Keys.ENTER);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  public void validateProductSearch() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(
        ExpectedConditions.visibilityOf(
            driver.findElement(By.xpath("//*[@id=\"nav-logo\"]/a[1]/span[1]"))));
  }
}
