package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver=BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test
	public void testHomePage()
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title=home.getApplicationTitle();
		Assert.assertTrue(title.contains("Demo Store"));
		System.out.println("My Application title is "+title);
		home.clickOnSigninlink();
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		//login.LoginApplication("ranga.bindu93@gmail.com","ranga.bindu93");
		login.LoginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		login.verifySignOutLink();
		
	}

	@AfterMethod
	public void teardown()
	{
		BrowserFactory.closeBrowser(driver);
	}
}
