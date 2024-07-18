/*
 * @author: Naveen Kumar Rajashekar
 */

package com.admin.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class MemberListFirstPage extends TestBase{
	
	LoginPage loginPage;
	
	//Initializing PageFactory
	public MemberListFirstPage() {
		super();   //Call the Constructor of the Super class - TestBase
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	//@Test(priority=1)
	public void PageTitleTest() {
		Assert.assertEquals("arif", "arif");
	}
	
	@Test(priority=1)
	public void DataRetritveTest() throws InterruptedException {
		
		///html/body/div[1]/div/div/main/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div[3]/h4/a
		///html/body/div[1]/div/div/main/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[2]/div[3]/h4/a
		
		
		
		///html/body/div[1]/div/div/main/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div[3]/h4/a
		
		int page=2;
		System.out.println("name,designation,contact,email,company_name,address");
		int i,j;
		
		for(j=3;j<=6;j++) {
			
			/*Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,700)");
			 
			jse.executeScript("window.scrollBy(0,700)");
			Thread.sleep(4000);
			WebElement mango=driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div/div/div[2]/div/div[4]/div[2]/nav/ul/li["+j+"]/a"));
			Actions actions = new Actions(driver);
			//actions.moveToElement(mango).click().perform();
			Thread.sleep(4000);
			mango.click();
			Thread.sleep(3000);
			*/
			//i=1;
			for(i=1;i<=15;i++)
			 {
				Thread.sleep(2000);
				System.out.println(i);
				
				//JavascriptExecutor jse = (JavascriptExecutor)driver;
				//jse.executeScript("window.scrollBy(0,750)");
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,140)");
				
					
				String name = null, designation=null, email=null, contact=null, company_name=null, company_address=null;
				
				//System.out.println("/html/body/div[1]/div/div/main/div/div[2]/div/div/div[2]/div/div[3]/div/div/div['+ i +']/div[3]/h4/a");
				Thread.sleep(2000);
			    WebElement fruits=driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div/div/div[2]/div/div[3]/div/div/div["+ i +"]/div[3]/h4/a"));
			    Thread.sleep(2000);
		        
			    fruits.click();
			    
			    Thread.sleep(2000);
			    
			    Object[] windowHandles=driver.getWindowHandles().toArray();
		        driver.switchTo().window((String) windowHandles[1]);
		        
		        try {
		        	WebElement representative_name=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/h1"));
			        name = representative_name.getText();
			        System.out.println(name);
			        
	        	}
	        	catch(Exception e) {
	        		name=" ";
	        	}
		        
		        
		        try {
		        	WebElement representative_designation=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/p[1]/span"));
			        designation = representative_designation.getText();
			        System.out.println(designation);
			        
	        	}catch(Exception e) {
	        		designation=" ";
	        	}
		        
		        try {
		        	WebElement representative_contact=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/p[2]/span"));
			        contact = representative_contact.getText();
			        System.out.println(contact);
			        
	        	}catch(Exception e) {
	        		contact=" ";
	        	}
		        
		        
		        try {
		        	WebElement representative_email=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/p[3]/span"));
			        email = representative_email.getText();
			        System.out.println(email);
			        
	        	}catch(Exception e) {
	        		email=" ";
	        	}
		        
		        
		        try {
		        	WebElement company_Name=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[1]/div/div[1]/h1"));
		        	company_name = company_Name.getText();
			        System.out.println(company_name);
			        
	        	}catch(Exception e) {
	        		company_name=" ";
	        	}
		        
		        
		        try {
		        	WebElement company_Address=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[1]/div/div[1]/p"));
		        	company_address = company_Address.getText();
			        System.out.println(company_address);
			        
	        	}catch(Exception e) {
	        		company_address=" ";
	        	}
		        
		        
		     
		        System.out.println("---------------------------***********------------------+iiii  - "+i+"--------------jjjjj   "+(j-1));
		        System.out.println("\""+name+"\",\""+designation+"\",\""+contact+"\",\""+email+"\",\""+company_name+"\",\""+company_address+"\"");
		        //closing current window
		        driver.close();
		        //Switch back to the old tab or window
		        driver.switchTo().window((String) windowHandles[0]);
			 }
			
			    System.out.println("---------------------------LOOOOOOOOOOOOOOOOOOOOOOOOOOOO**********------------------");
			    JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,700)");
				 
				jse.executeScript("window.scrollBy(0,700)");
				//Thread.sleep(4000);
				WebElement mango=driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div/div/div[2]/div/div[4]/div[2]/nav/ul/li["+j+"]/a"));
				Actions actions = new Actions(driver);
				actions.moveToElement(mango).click().perform();
				Thread.sleep(4000);
				mango.click();
			
			 
			 //System.exit(0);
		}
		
		
		//Assert.assertEquals("arif", "arif");
	}/**
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}**/

}
