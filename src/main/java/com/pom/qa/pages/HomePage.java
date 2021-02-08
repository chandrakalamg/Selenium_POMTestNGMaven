package com.pom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pom.qa.base.BaseTest;



public class HomePage extends BaseTest{
	@FindBy(xpath = "//span[contains(text(),'chandrakala mg')]")
	@CacheLookup
	WebElement userNameLabel;

	//@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	
	@FindBy(xpath ="//div[@class='menu-item-wrapper']")
	WebElement navLink;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newContact;
	
	
	@FindBy(xpath="//div[text()='Create New Contact']")
	WebElement createNewContact;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNavbarAndContacts(){
		Actions action = new Actions(driver);
		action.moveToElement(navLink).build().perform();
		//contactsLink.click();
		//return new ContactsPage();
		
	}
	
	public ContactsPage clickOnContactsLink(){
		clickOnNavbarAndContacts();
		contactsLink.click();
		return new ContactsPage();
	}
	
	
	/*
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	*/
}
