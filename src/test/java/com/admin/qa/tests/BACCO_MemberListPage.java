/*
 * @author: Naveen Kumar Rajashekar
 */

package com.admin.qa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class BACCO_MemberListPage extends TestBase{
	
	LoginPage loginPage;
	
	//Initializing PageFactory
	public BACCO_MemberListPage() {
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
		
		Thread.sleep(6000);
		
		int i;
		for(i=1;i<=20;i++)
		 {
			Thread.sleep(6000);
			//System.out.println(i);
			
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,90)");
			
				
			String membership_id = null, website=null, email=null, contact=null, company_name=null, company_address=null;
			
			//System.out.println("/html/body/div[2]/section/div/div/div[2]/div[3]/div[i]/div/div/a[2]");
			Thread.sleep(4000);
			WebElement mango=driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[3]/div["+ i +"]/div/div/a[2]"));
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//WebElement mango = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[3]/div["+ i +"]/div/div/a[2]")));
			
			Thread.sleep(4000);
			Actions actions = new Actions(driver);
			actions.moveToElement(mango).click().perform();
			//Thread.sleep(4000);
			//mango.click();  
						    
		   
		    
		    //Object[] windowHandles=driver.getWindowHandles().toArray();
	        //driver.switchTo().window((String) windowHandles[1]);
	        
		    Thread.sleep(10000);
		    
		    String xpath = "/html/body/div[2]/section[1]/div/img";                 // Define the XPath
		    List<WebElement> elements = driver.findElements(By.xpath(xpath));      // Find elements matching the XPath
		    
		    if (!elements.isEmpty()) {                                             // Check if any elements were found
	            WebElement image = elements.get(0);
	            
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("window.scrollBy(0,280)");                        // Scroll by (0, 280) if the element is found
	        }	
		    
		    else continue;

        	        
		      Thread.sleep(6000);
		      
	        try {
	        	WebElement representative_website=driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div/div/div/div[2]/div/div[1]/div[4]/div[1]/a"));
		        website = representative_website.getText();
		        //System.out.println(website);                               
		        
        	}catch(Exception e) {
        		website=" ";
        	}
        	

	        
	        try {
	        	WebElement representative_contact=driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div/div/div/div[2]/div/div[1]/div[2]/div/p"));
		        contact = representative_contact.getText();
		        //System.out.println(contact);
		        
        	}catch(Exception e) {
        		contact=" ";
        	}
	        
	        
	        try {
	        	WebElement representative_email=driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div/div/div/div[2]/div/div[1]/div[3]/div/p"));
		        email = representative_email.getText();
		        //System.out.println(email);
		        
        	}catch(Exception e) {
        		email=" ";
        	}
	        
	        
	        try {
	        	WebElement company_Name=driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div/div/div/div[1]/h5"));
	        	company_name = company_Name.getText();
		        //System.out.println(company_name);
		        
        	}catch(Exception e) {
        		company_name=" ";
        	}
	        
	        
	        try {
	        	WebElement company_Address=driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div/div/div/div[2]/div/div[1]/div[1]/div/p"));
	        	company_address = company_Address.getText();
		        //System.out.println(company_address);
		        
        	}catch(Exception e) {
        		company_address=" ";
        	}
	        
	        
	     
	        //System.out.println("---------------------------***********------------------+iiii  - "+i+"--------------jjjjj   "+(j-1));
	        System.out.println("\""+company_name+"\",\""+contact+"\",\""+email+"\",\""+website+"\",\""+company_address+"\"");
	        
	        driver.navigate().back();

	        
		 }
		
	    
		
		Thread.sleep(2000);
		
		
		//Assert.assertEquals("arif", "arif");
	}/**
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}**/

}
