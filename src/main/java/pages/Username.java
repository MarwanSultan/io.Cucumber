package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Username extends BasePage {


	@FindBy(id = "ap_email")
	WebElement userID;

	@FindBy(id = "continue")
	WebElement continueButton;

	public void userNamePageInitialized() {
		userID.isDisplayed();
	}

	public Username(WebDriver driver) {
		super(driver);
	}

	public void enterUsername(String user) {
		userID.sendKeys(user);
	}

	public void submitUserName(String user) {
		enterUsername(user);
		continueButton.click();
	}
}
