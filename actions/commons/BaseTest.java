package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	
	public enum BROWSER{
		CHROME,FIREFOX,EDGE,IE;
	}
	protected WebDriver multiBrowser(String browserName) {
		BROWSER browser  = BROWSER.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX: 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			break;
		default:
			break;
		}
		return driver;
	}
	
	protected WebDriver multiBrowser(String browserName, String url) {
		BROWSER browser  = BROWSER.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX: 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			break;
		default:
			return (WebDriver) new RuntimeException("Please enter correct browser!");
		}
		return driver;
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		return "mark" + rand.nextInt(99999) + "@gmail.com";
	}
}
