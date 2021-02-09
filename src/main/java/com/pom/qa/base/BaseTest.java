package com.pom.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pom.qa.util.TestUtil;

public class BaseTest {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTest(){
		//System.out.println(System.getProperty("user.dir")+ "/src/main/java/com/pom/qa/config/config.properties");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/pom"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
			String browserName = prop.getProperty("browser");
			String UserDir= System.getProperty("user.dir");
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", UserDir +"/softwares/chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.setProperty("Webdriver.gecko.driver",UserDir+"\\softwares\\geckodriver.exe");
				driver = new FirefoxDriver(); 
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		
	}
	
}
