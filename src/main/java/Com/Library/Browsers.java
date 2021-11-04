package Com.Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers 

{
   public WebDriver driver;
	
	public void webbrowserLaunch(String url)
	{
		
		try
		{
		
		//Chrome driver setup initialization
		
		WebDriverManager.chromedriver().setup();
		
		// create object for chrome driver
		
		
		 driver = new ChromeDriver();
		
		
		//Passing url
		
		
		driver.get(url);
		
		
		
		// maximize screen
		
		
		driver.manage().window().maximize();
		
		}
		
		
		
		catch(Exception E)
		{
			// Handle exception
			
			System.out.println("Exception" +E);
			
		}
		
	
	
		}
	
}
