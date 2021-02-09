package com.pom.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pom.qa.base.BaseTest;

public class ContactsPage extends BaseTest {

	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLabel;
	
	/*@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newContact;
	*/
	@FindBy(xpath="//button[text()='New' and @class='ui linkedin button']")
	WebElement newContact;
	
	@FindBy(xpath="//div[text()='Create New Contact']")
	WebElement createNewContact;
		
	@FindBy(name="first_name")
	WebElement firstnameInput;
	
	@FindBy(name="last_name")
	WebElement lastnameInput;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveContact;
	
	@FindBy(xpath="//div[text()='123 456']")
	WebElement newUsername;
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
		
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void newContact() {
		
	//	newContact.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", newContact);
    	
		Assert.assertEquals(createNewContact.getText(), "Create New Contact","Crate new contact page not found");
	}
	
	public void newContactInput(String fn,String ln) {
		firstnameInput.sendKeys(fn);
		lastnameInput.sendKeys(ln);
		saveContact.click();
		String newName =fn+" "+ln;
		verifyNewContactByName(newName);
	//	Assert.assertEquals(newUsername.getText(), "123 456","New User not created");
	}
	
	public void verifyNewContactByName(String name){
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='"+name+"']")).getText(),name,"New Contact not created");
		
	}
	
	
	
}
