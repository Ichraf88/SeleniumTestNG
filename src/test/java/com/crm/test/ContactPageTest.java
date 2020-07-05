package com.crm.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.util.TestUtils;
import com.pages.ContactPage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class ContactPageTest extends TestBase{

	public ContactPageTest() throws IOException {
		super();
		
	}
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	@Parameters({"browser"})
	@BeforeMethod
	public void Login(String browser) throws IOException {
		initialization(browser);
		loginPage = new LoginPage();
		homePage=loginPage.performLogin();
		
		
	}
	
	
	@Test(dataProvider = "testData")
	public void addContact(String ftName,String ltName,String companyName,String departmentName  ) throws IOException {
	homePage.switchToFrame();
	
		contactPage=homePage.clickOnNewContact();
		
		
}
	
	@DataProvider
	public Object[][] testData() throws IOException
	{
		Object data[][]=TestUtils.getDataFromExcel("Feuil1");
		return data;
	}
	
	@AfterMethod
	public void down() {
		driver.quit();
	}

}
