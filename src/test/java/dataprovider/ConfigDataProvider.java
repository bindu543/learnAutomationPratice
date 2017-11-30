package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;

	public ConfigDataProvider(){
		
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			 pro = new Properties();
			
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Exception is"+e.getMessage());
		}
		
	}
	public String getIEpath()
	{
		String url=pro.getProperty("IEpath");
		return url;
	}
	
	public String getChromepath()
	{
		String url=pro.getProperty("Chromepath");
		return url;
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("url");
		return url;
	}
}
