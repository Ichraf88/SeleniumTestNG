package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Contacts']")
	WebElement Contacts;

	@FindBy(xpath="//a[text()='Deals']")
	WebElement Deals;

	@FindBy(xpath="//a[text()='Tasks']")
	WebElement tasks;



	@FindBy(xpath="//a[text()='New Contact']")
	WebElement addNewContact;

	@FindBy(xpath="//td[text()='Status']")
	WebElement contactStatut;

	@FindBy(xpath="//td[text()='Keyword']")
	WebElement dealKeyword;

	@FindBy(xpath="//td[text()='Keyword']")
	WebElement taskKeyword;

	public void switchToFrame() {
		// TODO Auto-generated method stub
		driver.switchTo().frame("mainPanel");

	}
	public ContactPage clickOnNewContact() throws IOException {
		Actions action=new Actions(driver);
		action.moveToElement(Contacts).build().perform();
		addNewContact.click();
		return new ContactPage();

	}
	public String getTitle() {
		String title=driver.getTitle();
		return title;

	}
	public void clickOnContacts() {

		Contacts.click();
	}
	public Boolean isContactStatutDisplayed() {

		Boolean isContactStatutDisplayed=contactStatut.isDisplayed();
		return isContactStatutDisplayed;
	}
	public void clickOnDeals() {

		Deals.click();
	}
	public Boolean isDealsKeywordDisplayed() {

		Boolean isDealsKeywordDisplayed=dealKeyword.isDisplayed();
		return isDealsKeywordDisplayed;
	}
	public void clickOnTasks() {

		tasks.click();
	}
	public Boolean isTasksKeywordDisplayed() {

		Boolean isTasksKeywordDisplayed=taskKeyword.isDisplayed();
		return isTasksKeywordDisplayed;
	}
}
