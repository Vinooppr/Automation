package package1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Elements.Element1;
import Com.Inputs.Input1;
import Com.Library.Browsers;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Login

{

	
	Browsers browser = new Browsers();
	
	Input1 input = new Input1();
	
	Element1 Element = new Element1();
	

@BeforeClass
public void OpenchromeBrowser()
{
	
browser.webbrowserLaunch(input.Guru99login);
	
}


@AfterClass

public void closeBrowser()
{
	
	browser.driver.close();
}


@DataProvider(name = "login")
public Object [][] getdata()
{
	
	Object[][] data =new Object[3][2];
	
	
	
	data[0][0] = "mngr363877";
	data[0][1] = "12345";
	
	
	
	data[1][0] = "qwert";
	data[1][1] = "pepagah";
	
	data[2][0] = "mngr363877";
	data[2][1] = "pepagah";
	return data;
}





@Test(dataProvider = "login", priority =1,description = "Guru99 login")
public void Login(String Username, String Password )
{
	
	
	WebElement UserId = browser.driver.findElement(By.xpath(Element.username));
	UserId.sendKeys(Username);
	
	WebElement password = browser.driver.findElement(By.xpath(Element.password));
	password.sendKeys(Password);
			
	WebElement Login = browser.driver.findElement(By.xpath(Element.Login));
	Login.click();
	
	Alert alert1 = browser.driver.switchTo().alert();
	alert1.accept();
	
	//browser.driver.close();
	
		
	
}








}