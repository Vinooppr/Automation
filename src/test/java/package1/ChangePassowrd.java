package package1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Elements.Element1;
import Com.Inputs.Input1;
import Com.Library.Browsers;
import Com.Utility.Excel;

public class ChangePassowrd 

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


@Test(priority =1,description = "Guru99 login")
public void Login()
{
	
	
	WebElement UserId = browser.driver.findElement(By.xpath(Element.username));
	UserId.sendKeys(input.username1);
	
	WebElement password = browser.driver.findElement(By.xpath(Element.password));
	password.sendKeys(input.password1);
			
	WebElement Login = browser.driver.findElement(By.xpath(Element.Login));
	Login.click();
	browser.driver.findElement(By.xpath(Element.changePassword)).click();
	//browser.driver.close();
	
	
	
}




@Test(dataProvider = "authentication ",priority =2,description = "Guru99 login")
public void Changepassword(String password1, String password2, String password3) throws Throwable
{
	System.out.println(password1+password2+password3);
	
//	WebElement UserId = browser.driver.findElement(By.xpath(Element.changePassword));
//	
//	UserId.click();
	
	
	browser.driver.findElement(By.xpath(Element.oldPassword)).sendKeys(password1);
	
	
	browser.driver.findElement(By.xpath(Element.NewPassword)).sendKeys(password2);
	
	
	browser.driver.findElement(By.xpath(Element.ConfirmPassword)).sendKeys(password3);;
	
	
				
	WebElement Submit = browser.driver.findElement(By.xpath(Element.SubmitCP));
	Submit.click();
	
	
	//change password
	
	browser.driver.findElement(By.xpath(Element.changePassword)).click();
	
}
	
	@DataProvider
	public Object[][] authentication ()
	{
		
	Excel dataconfig=new Excel("C:\\Users\\vinoop\\eclipse-workspace\\Project2\\excel_change_pswd.xlsx");
	int rows=dataconfig.getRowCount(0);
	Object[][] data=new Object[2][3];
	for(int i=1;i<rows;i++)
	{
		
		data[i][0]=dataconfig.getData(0, i, 0);
		data[i][1]=dataconfig.getData(0, i, 1);
		data[i][2]=dataconfig.getData(0, i, 2);
		
	}
	return data;
			
	}

}
	
	
	

