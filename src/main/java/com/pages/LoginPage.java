package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase {
	
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png']")
			WebElement logo;
	
	@FindBy(name=("username"))
	WebElement usernameText;
	
	@FindBy(name=("password"))
	WebElement passwordText;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement logbutton;
	
	public String gettitle() {
		String actualtitle=driver.getTitle();
		return actualtitle;

	}
	public String getURL() {
		String actualURL=driver.getCurrentUrl();
		return actualURL;
		
	}
	public boolean logoIsDisplayed() {
		boolean logoIsDisplayed=logo.isDisplayed();
		return logoIsDisplayed;
		
	}
	
	public HomePage performLogin() throws IOException {
		usernameText.sendKeys(prop.getProperty("userName"));
		passwordText.sendKeys(prop.getProperty("password"));
		logbutton.click();
		return new HomePage();
	}

}
