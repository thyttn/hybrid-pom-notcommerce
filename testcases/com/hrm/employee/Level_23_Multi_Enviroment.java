package com.hrm.employee;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Login;
import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.GlobalConstants;
import environmentConfig.Environment;
import generatorManager.GenerateManagerObject;
import generatorManager.HomePageObject;
import generatorManager.MyAccountPagesObject;
import generatorManager.RegisterPageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.hrm.AddEmployeePageObject;
import pageObject.hrm.DashboardPageObject;
import pageObject.hrm.EmployeeListPageObject;
import pageObject.hrm.LoginPageObject;
import pageObject.hrm.MyInfoPageObject;
import pageObject.hrm.PageGenerator;
import pageObject.hrm.MyInfoPageObject;
import pageUIs.hrm.CommonPageUI;
import pageUIs.hrm.EmployeeListPageUI;
import reportConfig.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

@Epic("Regression test")
@Feature("Register and Login")
public class Level_23_Multi_Enviroment extends BaseTest {
	WebDriver driver;
	Environment envi;

	@Parameters({"browser","environment"})
	@BeforeClass
	public void beforeTest(String browserName, String environmentName) {
		ConfigFactory.setProperty("env", environmentName);
		
		envi = ConfigFactory.create(Environment.class);
		driver = multiBrowser(browserName, envi.getUrlApp());
		System.out.println("Test enviroment " + envi.getUrlApp());	
	}

	@Test
	public void Employee_01_Add_New_Employee() {}

	@AfterClass(alwaysRun = true)
	public void afterTest() {
		log.info("Pre-condition: close browser and driver");
		closeBrowserAndDriver();
	}
}
