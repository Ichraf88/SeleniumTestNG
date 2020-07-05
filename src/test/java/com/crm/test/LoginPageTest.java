package com.crm.test;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.crm.base.TestBase;
import com.crm.util.TestUtils;
import com.pages.HomePage;
import com.pages.LoginPage;


public class LoginPageTest extends TestBase {
	
	

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
LoginPage loginPage;
HomePage homePage;


	@Parameters({"browser"})
	@BeforeMethod
	public void setup( String browser) throws IOException {
		initialization(browser);
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void titletest(Method method) throws IOException {
		
		//driver.manage().window().maximize();
		//String ExpectedResult="CRMPRO  - CRM software for customer relationship management, sales, and support.";
     //  String actualResult= loginPage.getTitle();
     // Assert.assertEquals(ActualResult, ExpectedResult,"the title is false");
      // SoftAssert softassert=new SoftAssert();
      // softassert.assertEquals("fff", "ghkh");
      // System.out.println("hhhhh");
      // softassert.assertEquals("cycy", "kiki");
      // softassert.assertAll();
       TestUtils.TakePicture(method.getName());
        
	}
	
	@Test(priority=2)
	public void checkUrl(Method method) throws IOException {
		
		String ExpectedResult="https://www.crmpro.com/index.html";
		String ActualResult=loginPage.getURL();
		System.out.println(ActualResult);	
		Assert.assertEquals(ActualResult, ExpectedResult,"the url flse");
		 TestUtils.TakePicture(method.getName());
	 }
	@Test(priority=3)
	public void TestLogo(Method method) throws IOException {
		
    boolean ExpectedResult=true;
    boolean ActualResult= loginPage.logoIsDisplayed();
   System.out.println(ActualResult);
   Assert.assertEquals(ActualResult, ExpectedResult,"the image is not displayed");
   TestUtils.TakePicture(method.getName());
  }
	
	
	@Test(priority=4)
	public void Login(Method method) throws IOException {
		homePage= loginPage.performLogin();
		String ExpectedResult="CRMPRO";
		String ActualResult=homePage.getTitle(); 
		Assert.assertEquals(ActualResult, ExpectedResult,"information to login false");
		 TestUtils.TakePicture(method.getName());
		}

	
	
	@AfterMethod
	public void down() {
		driver.quit();
	}
	
}
