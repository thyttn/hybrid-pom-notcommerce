package pageObjectLiveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUINopCommerce.CommonUI;
import pageUINopCommerce.MyAccountUI;

public class MyAccountPageObject extends BasePage {

	WebDriver driver;
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
