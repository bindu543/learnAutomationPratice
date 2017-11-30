package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	 WebDriver driver;

	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath="//a[text()='Sign In']")WebElement signInlink;
	@FindBy(xpath="//a[text()='My Account']")WebElement myaccountlink;
	@FindBy(xpath="//a[text()='My cart']")WebElement mycartlink;
	@FindBy(xpath="//a[text()='Checkout']")WebElement checkoutlink;
	
	public void clickOnSigninlink()
	{
		signInlink.click();
	}
	public void clickOnMyAccountlink()
	{
		myaccountlink.click();
	}
	public void clickOnMycartlink()
	{
		mycartlink.click();
	}
	public void clickOnCheckoutlink()
	{
		checkoutlink.click();
	}
	public String getApplicationTitle() 
	{
		return driver.getTitle();
		
	}

}
