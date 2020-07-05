package com.crm.test;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.util.TestUtils;
import com.pages.HomePage;
import com.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	
	LoginPage loginPage;
    HomePage homePage;
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@Parameters({"browser"})
	@BeforeMethod
	public void Login(String browser) throws IOException {
		initialization(browser);
		loginPage=new LoginPage();
		homePage=loginPage.performLogin();
		
	}
	
	@Test(priority=5)
	public void OnClickContactsTest(Method method) throws IOException {
		//WebElement frame=driver.findElement(By.xpath("//frame[@name='mainpanel']"));
	homePage.switchToFrame();
		homePage.clickOnContacts();
		//Actions action =new Actions(driver);
		//action.moveToElement(Contacts).build().perform();
        
       boolean ActualResult= homePage.isContactStatutDisplayed();
       Assert.assertTrue(ActualResult,"Status not displayed");
       TestUtils.TakePicture(method.getName());
		
	}
	@Test(priority=6)
	public void OnClickDealsTest(Method method) throws IOException {
		//WebElement frame=driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		homePage.switchToFrame();
	homePage.clickOnDeals();

       boolean ActualResult= homePage.isDealsKeywordDisplayed();
       Assert.assertTrue(ActualResult,"Status not displayed");
       TestUtils.TakePicture(method.getName());
		
	}
	@Test(priority=7)
	public void OnClickTasksTest(Method method) throws IOException {
		//WebElement frame=driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		homePage.switchToFrame();
		homePage.clickOnTasks();
  
       boolean ActualResult= homePage.isTasksKeywordDisplayed();
       Assert.assertTrue(ActualResult,"Status not displayed");
       TestUtils.TakePicture(method.getName());
	}
	@AfterMethod
	public void down() {
		driver.quit();
	}

}
