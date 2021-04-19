package com.ul.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;



public class CollectionSubMenuPage  {
	WebDriver driver;
	 Properties prop = new Properties();
	 
	 //Element Locators:
	 By collectionElements = By.xpath("//*[@id='topnav_wrapper']/ul/li[10]/span");
	 By submenuElements = By.xpath("//ul[@class='taxonslist']/li/a/span");
	 By studychairsElements=By.xpath("/html/body/div[1]/header/div[2]/div/nav/div/ul/li[10]/div/div/ul/li[1]/ul/li[1]/a/span");
	 By exclude=By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[1]/div/form/div[2]/div/input");
       List<String> priceList = new ArrayList<>();
	 
	 //Element Locators:
	    By priceListElements = By.xpath("//div[@class='price-number']/span");
		By nameListElements = By.xpath("//span[@class='name']");
		int price;

	public CollectionSubMenuPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//For Clicking on Collection menu:
	public void clickOnCollection() throws InterruptedException {
		 WebElement collection = driver.findElement(collectionElements);
		 driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
	      collection.click();
	      driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
	}
	
	//To store the Submenus of Bring At Home:
	public void displaySubmenu() throws Exception
	 {
	  List<WebElement>allMenu = driver.findElements(submenuElements);
      System.out.println("\n"+"The submenu list from 'Being at home' column:");
      Reporter.log("\n"+"The submenu list from 'Being at home' column:");
  
      List<String> submenuList = new ArrayList<>();
      int submenuSize = allMenu.size();
      
      for(int i=0;i<submenuSize;i++)
	        { 
     	 String menu = allMenu.get(i).getText();
     	 submenuList.add(menu);
	        }
      submenuList.removeAll(Arrays.asList("", null));
      
      
      for(int i=0;i<13;i++)
	        {
	        	System.out.println(submenuList.get(i).toString());
	        	Reporter.log(submenuList.get(i).toString());
	        }


	    }
	public void studyChairs() throws InterruptedException {
		 WebElement studychairs = driver.findElement(studychairsElements);
		 driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
	      studychairs.click();
	      driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
	}
	public void excludeOutOfStock() throws InterruptedException
	{
		WebElement excludeout=driver.findElement(exclude);
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		excludeout.click();
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		
	}
	
	public void getChairsDetails() {
		List <WebElement> allPrice =  driver.findElements(priceListElements);
		List <WebElement> allName =  driver.findElements(nameListElements);
		
		System.out.println("\n"+ "3 study chair details with highest recommendation");
       Reporter.log("\n"+ "The price of the first three study chair");

       String pric, name;
       
       	
	     int size = allPrice.size();
	     for(int i=0;i<size;i++)
	     { 
	     pric = allPrice.get(i).getText();
	     name= allName.get(i).getText();
	     pric = pric.replaceAll("₹","");
	     pric = pric.replaceAll(",","");
	     price = Integer.parseInt(pric);
	     priceList.add(name+":");
    	 priceList.add("Rs."+pric);
	     }
	     for(int i=0;i<6;i++)
	     {
    	System.out.println(priceList.get(i).toString());
    	Reporter.log(priceList.get(i).toString());
	     }
	}

	
	
		// TODO Auto-generated method stub
	//For Taking ScreenShot of the error alert message:
    public void takeScreenShot2() throws InterruptedException {
    	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(screenshot,
			new File(System.getProperty("user.dir")+"\\screenshot\\collection.png"));
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}		
    }
	




}


