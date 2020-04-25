package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Password extends BasePage {


	@FindBy(id = "ap_password")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement submit;

	public Password(WebDriver driver) {
		super(driver);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void submitPassword(String pass) {
		enterPassword(pass);
		submit.click();
	}
}
