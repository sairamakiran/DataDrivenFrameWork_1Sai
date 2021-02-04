package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class AddContact extends TestBase {
  
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void Add_Contact(String company,String firstname,String lastname) throws InterruptedException
	{		
		Login obj = new Login();
		obj.Login_Creds("ssairamakiran@mirabeltechnologies.com","Mirabel@123");
		click("Contacts_ID");
		click("AddContact_ID");		
        WebElement frame = driver.findElement(By.xpath("//*[contains(@class, 'x-component x-fit-item x-component-default')][contains(@name, 'Tab')]"));
       // WebElement frame1=driver.findElement(By.xpath("//*[contains(@class, 'x-component x-fit-item x-component-default')][contains(@name, 'Tab')][contains(@src,'customersedit')]"));        	
        	driver.switchTo().frame(frame);
        	wait.until(ExpectedConditions.elementToBeClickable(By.id("CompanyName_ID")));
      		type("CompanyName_ID",company);
      		type("FirstName_ID",firstname);
      		type("LastName_ID",lastname);
      		Thread.sleep(5000);
      		click("SaveContact_ID");
      		Thread.sleep(10000);
      		driver.switchTo().defaultContent();   
	}
}
