package com.pom.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.pages.HomePage;
import com.pom.qa.base.BaseTest;

public class LoginPage extends BaseTest {
	//Page Factory - OR:
		@FindBy(xpath="//input[@name='email' and @placeholder='E-mail address']")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//span[text()='Log In']")
		WebElement mainPage_loginBtn;
		
		@FindBy(xpath="//div[text()='Login']")
		WebElement loginBtn;
		
		/*
		@FindBy(xpath="//span[contains(text(),'Remove Frame')]")
		WebElement rmFrame;
		
		*/
		//logo verify - recheck
		@FindBy(xpath="//image[contains(@src,'/images/cogtiny1.jpg')]")
		WebElement freecrmLogo;
				
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
	
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return freecrmLogo.isDisplayed();
		}
		
		public void mainlogin() {
			mainPage_loginBtn.click();
		}
		
		public HomePage login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage();
		}
}
