package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String CaptureScreenshot(WebDriver driver, String screenshotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destination = "E:\\java programs\\com.learnautomation.hybrid\\Screenshots"
													+screenshotName+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(src,new File(destination));
		} catch (IOException e) 
		{
			System.out.println("Failed to Capture screenshots"+e.getMessage());
		}
		return destination;
	}

}
