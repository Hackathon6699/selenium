package com.ul.qa.base;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {
	
	
	public static String browsertype;
	public static WebDriver driver;
	static String projectPath = System.getProperty("user.dir");
	
	
	public static WebDriver driverInstantiate(String browser) 
	{
	browsertype= browser;
	WebDriver driver = null;
		if(browsertype.equalsIgnoreCase("chrome")) 
		{
		//USING LOCAL WEBDRIVER
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		}
		else if(browsertype.equalsIgnoreCase("firefox")) {

			//USING LOCAL WEBDRIVER
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}	
		else if(browsertype.equalsIgnoreCase("Edge")) {

			//LOCAL WEBDRIVER
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +"\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	public static Properties setProperties() throws IOException {
		Properties prop = new Properties();
		FileInputStream input = null;
		input = new FileInputStream(projectPath+"//src//main//java//com//ul//qa//config//config.properties");
		prop.load(input);
		
		return prop;
	}
	
	
	public void closeDriver()
	{
		driver.close();
	}
}
		
	


