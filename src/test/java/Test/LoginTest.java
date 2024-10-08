package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Page.Home;
import Page.Login;
import utilities.ExtentReportManager;
import utilities.PropertiesUtil;
import utilities.ScreenshotUtil;
import utilities.WebdriverUtil;

@Listeners(utilities.TestListener.class)
public class LoginTest {
	
	private WebDriver driver;
	
	private WebdriverUtil webDriverUtil;
	
	private ExtentTest test;
	
	private PropertiesUtil propertiesUtil;
	
	
	@BeforeTest
	public void setup() {
		
		webDriverUtil = new WebdriverUtil();
		driver = webDriverUtil.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		propertiesUtil = new PropertiesUtil("config.properties");
		driver.get(propertiesUtil.getProperty("url"));
		test = ExtentReportManager.createTest("Login Test");
	}
	
	@Test(priority = 1)
	public void loginpage() {
		ExtentReportManager.getTest().info("Navigating to Login Page");
		Login login = new Login(driver);
		
		login.enterUsername(propertiesUtil.getProperty("username"));
		
		login.enterPassword(propertiesUtil.getProperty("password"));
		
		ExtentReportManager.attachScreenshot(ScreenshotUtil.getScreenshotAsByteArray(driver), "Login Page");
		
		login.clicksubmit();
		
		
		ExtentReportManager.getTest().pass("Login Test Passed");
	}
	
	@Test(priority = 2)
	public void homepage() {
		
		ExtentReportManager.getTest().info("Navigating to Home Page");
		
		Home home = new Home(driver);
		String hom = home.logoPresent();
		
		
		ExtentReportManager.attachScreenshot(ScreenshotUtil.getScreenshotAsByteArray(driver), "Home Page");
		
		
		 
		 if (hom.equalsIgnoreCase("Login")) {
	            ExtentReportManager.getTest().pass("Home Page Test Passed");
	        } else {
	            ExtentReportManager.getTest().fail("Home Page Test Failed");
	        }
		 
		 
		
	}
	
	@AfterTest
	public void tearDown() {
		ExtentReportManager.flush();
	}

}
