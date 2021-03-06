package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="account_sign_in_form_email_id") WebElement username;
	
	@FindBy(name="passwd") WebElement password;
	
	@FindBy(xpath="//input[@value='Sign In']") WebElement SingInbutton;
	
	//@FindBy(xpath="//div[@class='pre-header']//a[text()='Sign Out']") WebElement SignOutbutton;
	
	By SignOut = By.xpath("//div[@class='pre-header']//a[text()='Sign Out']");
	
	public void LoginApplication(String user,String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		SingInbutton.click();
	}

	public void verifySignOutLink() 
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(SignOut));
		String text=ele.getText();
		Assert.assertEquals(text,"Sign Out","Sign out link not verified properly");
	}


	

}
