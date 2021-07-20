package pageObjectJquery;

import org.openqa.selenium.WebDriver;

public class GenerateManagerObject {
	private static HomePageObject homePage;
	
	private GenerateManagerObject(){
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage == null) {
			return new HomePageObject(driver);
		}
			return homePage;
	}
	
}
