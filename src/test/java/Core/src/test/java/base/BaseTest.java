package Core.src.test.java.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AmazonHome;

public class BaseTest {

	WebDriverWait wait;
	public WebDriver driver;
	AmazonHome amazonHome;

	@Before
	public void setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AmazonHome amazonHome = new AmazonHome(driver);
		amazonHome.initialize();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(){
		driver.quit();
	}


}
