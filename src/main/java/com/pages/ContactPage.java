package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class ContactPage extends TestBase{

	public ContactPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(id="department")
	WebElement department;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement save;
	
	
	
	public void addNewContact() {
		firstName.sendKeys("");
		lastName.sendKeys("");
		company.sendKeys("");
		department.sendKeys("");
		save.click();
	}
	
}
