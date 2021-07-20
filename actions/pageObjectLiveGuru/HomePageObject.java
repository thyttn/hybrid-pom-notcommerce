package pageObjectLiveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUILiveGuru.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToMyaccountBottomLink() {
		waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_BOTTON_LINK_LOCATOR);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_BOTTON_LINK_LOCATOR);
	}

}
