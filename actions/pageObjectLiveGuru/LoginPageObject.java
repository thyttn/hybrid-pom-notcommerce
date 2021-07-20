package pageObjectLiveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUILiveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void enterEmailTxt(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_LOCATOR);
		sendKeyToElement(driver, LoginPageUI.EMAIL_LOCATOR, email);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON_LOCATOR);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON_LOCATOR);
	}

	public void enterPasswordTxt(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_LOCATOR);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_LOCATOR, password);
	}

	public String getEmptyEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_MESSAGE_LOCATOR);
		return getTextValue(driver, LoginPageUI.EMPTY_EMAIL_MESSAGE_LOCATOR);
	}

	public String getEmptyPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_MESSAGE_LOCATOR);
		return getTextValue(driver, LoginPageUI.EMPTY_PASSWORD_MESSAGE_LOCATOR);
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_MESSAGE_LOCATOR);
		return getTextValue(driver, LoginPageUI.INVALID_EMAIL_MESSAGE_LOCATOR);
	}

	public String getInvalidPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_MESSAGE_LOCATOR);
		return getTextValue(driver, LoginPageUI.INVALID_PASSWORD_MESSAGE_LOCATOR);
	}

	public void refreshLoginPage(WebDriver driver) {
		getRefreshPage(driver);
	}

	public String getIncorrectEmailOrPassword() {
		waitForElementVisible(driver, LoginPageUI.INCORRECT_EMAIL_PASSWORD_MESSAGE_LOCATOR);
		return getTextValue(driver, LoginPageUI.INCORRECT_EMAIL_PASSWORD_MESSAGE_LOCATOR);
	}

}
