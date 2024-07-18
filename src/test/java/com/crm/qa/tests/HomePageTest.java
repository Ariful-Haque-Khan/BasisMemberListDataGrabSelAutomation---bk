/*
 * @AutomationTester: Md. Abdullah AL Rumy
 */
package com.crm.qa.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtils;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	//Initializing PageFactory
	public HomePageTest() {
		super();   //Call the Constructor of the Super class - TestBase
	}
	/*
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		homePage = loginPage.login(props.getProperty("username"),props.getProperty("password"));
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
	}
	
	
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Home page title not matched.");
	}
	
	
	
	@Test(priority=2)
	public void CRMPROLogoImageTest() {
		testUtils.switchToFrame();
		Boolean b = homePage.validateCRMPROImage();
		Assert.assertTrue(b);
	}
	
	
	@Test(priority=3)
	public void CRMPROUserNameTest() {
		testUtils.switchToFrame();
		Boolean b = homePage.verifyUserName();
		Assert.assertTrue(b);
	}
	
	@Test(priority=4)
	public void verifyContactsLinkTest() {
		testUtils.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@Test(priority=5)
	public void verifyDealsLinkTest() {
		testUtils.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	
	@Test(priority=6)
	public void verifyTasksLinkTest() {
		testUtils.switchToFrame();
		tasksPage = homePage.clickOnTasksLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
	*/
	 private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
	  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	  private static final String TOKENS_DIRECTORY_PATH = "tokens/path";

	  /**
	   * Global instance of the scopes required by this quickstart.
	   * If modifying these scopes, delete your previously saved tokens/ folder.
	   */
	  private static final List<String> SCOPES =
	      Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
	  private static final String CREDENTIALS_FILE_PATH = "/credential_google_sheet_api.json";

	  /**
	   * Creates an authorized Credential object.
	   *
	   * @param HTTP_TRANSPORT The network HTTP Transport.
	   * @return An authorized Credential object.
	   * @throws IOException If the credentials.json file cannot be found.
	   */
	  private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
	      throws IOException {
	    // Load client secrets.
	    InputStream in = HomePageTest.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
	    if (in == null) {
	      throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
	    }
	    GoogleClientSecrets clientSecrets =
	        GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

	    // Build flow and trigger user authorization request.
	    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
	        .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
	        .setAccessType("offline")
	        .build();
	    LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
	    return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	  }
	  
	  @Ignore  
		public void homePageTitleTest2() throws IOException, GeneralSecurityException {
		  initialization();
		  testUtils = new TestUtils();
			  for(int i = 1; i<=50; i++) {
			  driver.get(props.getProperty("url")+i);
			  String strUrl = props.getProperty("url")+i;
			  //String strUrl = driver.getCurrentUrl();
			  HttpURLConnection cn = (HttpURLConnection)new URL(strUrl).openConnection();
			  cn.setRequestMethod("HEAD");
			  cn.connect();
			  int res = cn.getResponseCode();
			  WebElement l;
			  if(res==200) {
				  System.out.println("test -----  ");
				  System.out.println(driver.findElements( By.className("fa-envelope") ).size());
				  if(driver.findElements( By.className("fa-envelope") ).size() != 0) {
					  if(driver.findElements( By.className("fa-facebook-f") ).size() == 0) {
						  l = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li/a"));
					  }else {
						  l = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li/a"));
					  }
					///html/body/section/div/div/div[2]/div/div/ul/li/a
						System.out.println("test -----  "+l);
					    // href value from getAttribute()
					    String v = l.getAttribute("href");
					    //System.out.println("Href value of link: "+ v);
					    String[] arrOfStr = v.split(":");
					    String a1 = null;
					    for (String a : arrOfStr) {
					        a1 = a;
					        //System.out.println(a);
					    }
					    
					    System.out.println(a1);
				  }
			  }
		  }
	  }
	  
	  
	  @Ignore
		public void homePageTitleTest3() throws IOException, GeneralSecurityException {
		  initialization();
		  testUtils = new TestUtils();
		  driver.get(props.getProperty("url")+26);
		  String strUrl = props.getProperty("url")+26;
		  //String strUrl = driver.getCurrentUrl();
		  HttpURLConnection cn = (HttpURLConnection)new URL(strUrl).openConnection();
		  cn.setRequestMethod("HEAD");
		  cn.connect();
		  int res = cn.getResponseCode();
		  WebElement l;
		  if(res==200) {
			  System.out.println("email size: -----  ");
			  System.out.println(driver.findElements( By.className("fa-envelope") ).size());
			  if(driver.findElements( By.className("fa-envelope") ).size() != 0) {
				  System.out.println("facebook size: -----  ");
				  System.out.println(driver.findElements( By.className("fa-facebook-f") ).size());
				  if(driver.findElements( By.className("fa-facebook-f") ).size() != 0) {
					  l = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li/a"));
				  }else {
					  l = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li[2]/a"));
				  }
				///html/body/section/div/div/div[2]/div/div/ul/li/a
					System.out.println("test -----  "+l);
				    // href value from getAttribute()
				    String v = l.getAttribute("href");
				    //System.out.println("Href value of link: "+ v);
				    String[] arrOfStr = v.split(":");
				    String a1 = null;
				    for (String a : arrOfStr) {
				        a1 = a;
				        //System.out.println(a);
				    }
				    
				    System.out.println(a1);
			  }
		  }
	  }
	  
	  
	  @Test(priority=1)
		public void homePageTitleTest4() throws IOException, GeneralSecurityException {
		  initialization();
		  for(int i = 2201; i<=2700; i++) {
			  testUtils = new TestUtils();
			  driver.get(props.getProperty("url")+i);
			  String strUrl = props.getProperty("url")+i;
			  //String strUrl = driver.getCurrentUrl();
			  HttpURLConnection cn = (HttpURLConnection)new URL(strUrl).openConnection();
			  cn.setRequestMethod("HEAD");
			  cn.connect();
			  int res = cn.getResponseCode();
			  WebElement l;
			  if(res==200) {
				  
				  //System.out.println("1st element size: -----  ");
				  //System.out.println(driver.findElements( By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li/a") ).size());
				  
				  if(driver.findElements( By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li/a") ).size() != 0) {
					  l = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li/a"));
					  //System.out.println("test -----  "+l);
				      // href value from getAttribute()
				      String v = l.getAttribute("href");
				      //System.out.println("Href value of link: "+ v);
				      String[] arrOfStr = v.split(":", 2);
				      
				      //System.out.println(arrOfStr[0]);
				      
				      if("mailto".equals(arrOfStr[0])) {
				    	  System.out.println(arrOfStr[1]);
				    	  continue;
				      }
				  }
				  else continue;
				  
				  //System.out.println("2nd element size: -----  ");
				  //System.out.println(driver.findElements( By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li[2]/a") ).size());
				  
				  if(driver.findElements( By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li[2]/a") ).size() != 0) {
					  l = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li[2]/a"));
				      String v = l.getAttribute("href");
				      String[] arrOfStr = v.split(":", 2);
				      
				      if("mailto".equals(arrOfStr[0])) {
				    	  System.out.println(arrOfStr[1]);
				      }
				  }
			  }
		  }
	  }

	  
	@Ignore  
	//@Test(priority=1)
	public void homePageTitleTest() throws IOException, GeneralSecurityException {
		//String title = homePage.validateHomePageTitle();
		initialization();
		testUtils = new TestUtils();
		
		//Assert.assertEquals("CRMPRO", "CRMPRO","Home page title not matched.");
		for(int i = 1; i<=2350; i++) {
			//driver.get(props.getProperty("url")+i);
			String strUrl = props.getProperty("url")+i;
			//String strUrl = driver.getCurrentUrl();
			HttpURLConnection cn = (HttpURLConnection)new URL(strUrl).openConnection();
		    cn.setRequestMethod("HEAD");
		    cn.connect();
		    int res = cn.getResponseCode();
		    
		    if(res==200) {
			    driver.get(props.getProperty("url")+i);
			    	driver.findElements( By.className("fa-envelope") ).size();
				    if(driver.findElements( By.className("fa-envelope") ).size() != 0) {
				    	//boolean exists = driver.findElements( By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li/a") ).size() != 0;
				    
					WebElement l = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li/a"));
					
					System.out.println("test -----  "+l);
				    // href value from getAttribute()
				    String v = l.getAttribute("href");
				    //System.out.println("Href value of link: "+ v);
				    String[] arrOfStr = v.split(":");
				    String a1 = null;
				    for (String a : arrOfStr) {
				        a1 = a;
				        //System.out.println(a);
				    }
				    
				    System.out.println(a1);
			    }
		    }
		}
		
		
		driver.get(props.getProperty("url")+"2323");
		//String textvalue=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li/a").getText());
		//System.out.println(textvalue);
		
		WebElement l = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/ul/li/a"));
		System.out.println("test -----  "+l.getSize());
		
	    // href value from getAttribute()
	    String v = l.getAttribute("href");
	    //System.out.println("Href value of link: "+ v);
	    String[] arrOfStr = v.split(":");
	    String a1 = null;
	    for (String a : arrOfStr) {
	        a1 = a;
	        //System.out.println(a);
	    }
	    
	    System.out.println(a1);
	    
	    
	    
	    /*
	    
	    // Build a new authorized API client service.
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	    final String spreadsheetId = "1RxSDjeG1ivfRLJL8bPH56n3IJyz3tJzuvtW6lJ5paqY";
	    final String range = "Sheet14!A1:G72";
	    Sheets service =
	        new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	            .setApplicationName(APPLICATION_NAME)
	            .build();
	    ValueRange response = service.spreadsheets().values()
	        .get(spreadsheetId, range)
	        .execute();
	    System.out.println(response.getValues());
	    List<List<Object>> values = response.getValues();
	    //System.out.println(values.get(2).get(3));
	    
	    List<String> myData = new ArrayList<>();
	    myData.add("hh@gmail.com");
	    myData.add("hhh@gmail.com");

	    
	    List<List<Object>> writeData = new ArrayList<>();
        for (String someData: myData) {
            List<Object> dataRow = new ArrayList<>();
            dataRow.add(someData);
            writeData.add(dataRow);
        }

        ValueRange vr = new ValueRange().setValues(writeData).setMajorDimension("ROWS");
        service.spreadsheets().values()
                .update(spreadsheetId, range, vr)
                .setValueInputOption("RAW")
                .execute();
        */
	}
	@AfterMethod
	public void tearDown() {
		//super.tearDown();
	}
}
