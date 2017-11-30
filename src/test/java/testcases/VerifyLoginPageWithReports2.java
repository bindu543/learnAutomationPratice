package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPageWithReports2 {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup()
	{
		report = new ExtentReports(".\\Reports\\LoginPageReport.html", true);
		logger = report.startTest("Verify Login Test");
		driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testHomePage()
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title=home.getApplicationTitle();
		Assert.assertTrue(title.contains("Demo Store"));
		logger.log(LogStatus.PASS, "Home Page loaded and verified");
		System.out.println("My Application title is "+title);
		home.clickOnSigninlink();
		logger.log(LogStatus.INFO, "Click on SignOut link");
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		//login.LoginApplication("ranga.bindu93@gmail.com","ranga.bindu93");
		login.LoginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),
				DataProviderFactory.getExcel().getData(0, 0, 1));
		logger.log(LogStatus.INFO, "Login to Application");
		login.verifySignOutLink();
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.CaptureScreenshot(driver, "validation2")));
		logger.log(LogStatus.PASS, "Signout link is present");
		
		
	}

	@AfterMethod
	public void teardown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path = Helper.CaptureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
