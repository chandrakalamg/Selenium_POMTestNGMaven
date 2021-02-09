package com.pom.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.qa.pages.ContactsPage;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.util.TestUtil;
import com.pom.qa.base.BaseTest;

public class ContactsPageTest extends BaseTest {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	   
	public ContactsPageTest(){
			super();
			
	}
	
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		loginPage.mainlogin();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	//	testUtil.switchToFrame();
	}
	/*
	@BeforeMethod
	public void beforemethod() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
		contactsPage.newContact();
	}
	*/
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void verifyNewContactTest(){
		contactsPage.newContact();
	}
	
	@Test(priority=3)
	public void verifyNewContactSingleDataTest(){
		//contactsPage.newContact();
		contactsPage.newContactInput("testing1","pom1");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getTestData")
	
	public void validateCreateNewContact(String firstName, String lastName){
		homePage.clickOnContactsLink();
		contactsPage.newContact();
		contactsPage.newContactInput(firstName, lastName);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
