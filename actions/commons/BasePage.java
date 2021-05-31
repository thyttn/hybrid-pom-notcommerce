package commons;

import java.util.List;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public  class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void getBackPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void getForwardPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void getRefreshPage(WebDriver driver) {
		driver.navigate().back();
	}

	public Alert waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		alert = waitAlertPresence(driver);
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		alert = waitAlertPresence(driver);
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		alert = waitAlertPresence(driver);
		return alert.getText();
	}

	public void sendKeytoAlert(WebDriver driver, String textValue) {
		alert = waitAlertPresence(driver);
		alert.sendKeys(textValue);
	}
	
	public void switchToWindowById(WebDriver driver, String parentId) {
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String runWindowId : allWindows) {
			if(!runWindowId.equals(parentId)) {
				driver.switchTo().window(runWindowId);
				break;
			}
		}
	}
	
	
	public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String actualWindowID : allWindows) {
			driver.switchTo().window(actualWindowID);
			String actualWindowTitle = driver.getTitle();
			if(actualWindowTitle.equals(expectedWindowTitle)) {
				break;
			}
		}
	}
	
	public void closeAllWindowExceptParent(WebDriver driver, String parentWindowTitle) {
		Set<String> allWindowIDs  = driver.getWindowHandles();
		
		for (String windowID : allWindowIDs) {
			driver.switchTo().window(windowID);
			String windowTitle = driver.getTitle();
			if(!windowTitle.equals(parentWindowTitle)) {
				driver.close();
			}
		}
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	public WebElement getFindElement(WebDriver driver,String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getFindElements(WebDriver driver,String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void clickToElement(WebDriver driver,String locator) {
		getFindElement(driver, locator).click();
	}
	public void sendKeyToElement(WebDriver driver,String locator, String valueSenkey) {
		getFindElement(driver, locator).clear();
		getFindElement(driver, locator).sendKeys(valueSenkey);
	}
	
	public void selectItemInDropdown(WebDriver driver,String locator,String textValue) {
		select = new Select(getFindElement(driver, locator));
		select.selectByVisibleText(textValue);
	}
	
	public String getSelectItemInDropdown(WebDriver driver,String locator) {
		select = new Select(getFindElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMutiple(WebDriver driver,String locator) {
		select = new Select(getFindElement(driver, locator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getFindElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public void sleepInSecond(long timeOutInSecond ) {
		try {
			Thread.sleep(timeOutInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getAttributeValue(WebDriver driver,String locator, String attributeName) {
		return getFindElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getCssValue(WebDriver driver,String locator, String attributeName) {
		return getFindElement(driver, locator).getCssValue(locator);
	}
	
	public String convertRgbaToHexa(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getFindElementSize(WebDriver driver,String locator) {
		return getFindElements(driver, locator).size();
	}
	
	public void checkToCheckBoxOrRadio(WebDriver driver,String locator) {
		if(!getFindElement(driver, locator).isSelected()) {
			getFindElement(driver, locator).click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver,String locator) {
		if(getFindElement(driver, locator).isSelected()) {
			getFindElement(driver, locator).click();
		}
	}
	
	public boolean isElementDisplay(WebDriver driver,String locator) {
		return getFindElement(driver, locator).isDisplayed();
	}
	public boolean isElementSelected(WebDriver driver,String locator) {
		return getFindElement(driver, locator).isSelected();
	}
	public boolean isElementEnable(WebDriver driver,String locator) {
		return getFindElement(driver, locator).isEnabled();
	}

	public void switchToIframe(WebDriver driver,String locator) {
		driver.switchTo().frame(getFindElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver,String locator) {
		driver.switchTo().defaultContent();
	}
	
	public void doubleClickToElement(WebDriver driver,String locator) {
		action = new Actions(driver);
		action.doubleClick().perform();;
	}
	public void hoverMouseToElement(WebDriver driver,String locator) {
		action = new Actions(driver);
		action.moveToElement(getFindElement(driver, locator)).perform();
	}
	public void rightClickToElement(WebDriver driver,String locator) {
		action = new Actions(driver);
		action.contextClick(getFindElement(driver, locator)).perform();
	}
	public void dragAndDropElement(WebDriver driver,String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getFindElement(driver, sourceLocator),getFindElement(driver, targetLocator)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver,String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getFindElement(driver, locator), key).perform();
		//key  = Keys.TAB...
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getFindElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getFindElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getFindElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getFindElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getFindElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getFindElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getFindElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitForAlertPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	private Actions action;
	private JavascriptExecutor jsExecutor;
	private Select select;
	private Alert alert;
	private WebDriverWait explicitWait;
	private long longTimeout;
}
