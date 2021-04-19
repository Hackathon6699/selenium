package com.ul.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class GiftCardPage {
	 WebDriver driver;
		Properties prop = new Properties();
		
		//Element Locators:
		By gift = By.xpath("//*[@id=\"header\"]/section/div/ul[2]/li[3]/a");
		By customizeGift = By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]");	
		By amount = By.xpath("//*[@id=\"ip_2251506436\"]");			
		By giftEnter =By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button");
		By senderName = By.xpath("//*[@id=\"ip_1082986083\"]");
		By recipentName = By.xpath("//*[@id=\"ip_4036288348\"]");			
		By recipentMail = By.xpath("//*[@id=\"ip_4081352456\"]");	
		By senderPhNo = By.xpath("//*[@id=\"ip_2121573464\"]");
		By mailEnter1 = By.id("ip_137656023");
		By mailEnter = By.xpath("//*[@id=\"ip_4081352456\"]");
		By submit = By.xpath("//*[@id=\"app-container\"]/div/main/section/section[3]/form/button");
		public static double Amount ;
		public static String Your_Name;
		public static String Your_Email ;
		public static long Your_Mobile ;
	    //Change the phone number from integer to string
		public static String phone ;
		public static String amount1 ;
		public static String Recipient_Name ;
		public static String Recipient_Email ;
		
		
		public GiftCardPage(WebDriver driver) throws Exception
		{
			this.driver = driver;
			String projectPath = System.getProperty("user.dir");
			
			//Getting data from excel file:
			File file = new File(projectPath+"\\Resource\\ULGiftCardEntry.xlsx");
			FileInputStream stream = new FileInputStream(file);
			XSSFWorkbook book = new XSSFWorkbook(stream);
			XSSFSheet sheet = book.getSheet("Sheet1");   
		    Amount = sheet.getRow(1).getCell(0).getNumericCellValue(); 
		    Your_Name = sheet.getRow(1).getCell(1).getStringCellValue();
		    Your_Email = sheet.getRow(1).getCell(2).getStringCellValue();
		    Your_Mobile = (long)sheet.getRow(1).getCell(3).getNumericCellValue(); 
		    //Change the phone number from integer to string
		     phone = String.valueOf(Your_Mobile);
		     amount1 = String.valueOf(Amount);
		     Recipient_Name = sheet.getRow(1).getCell(4).getStringCellValue();  
		     Recipient_Email = sheet.getRow(1).getCell(5).getStringCellValue();
		     book.close();
		}
		
		//For clicking on GiftCard menu:
		public void clickOnGiftCard() throws InterruptedException {
			 driver.findElement(gift).click();
			 driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
			
		}
		
		//For clicking on Birthday/Anniversary (choosen):
		public void selectCard() throws InterruptedException  {
			driver.findElement(customizeGift).click();	
			driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		}
		
		//For entering the amount value:
		public void setAmount() throws InterruptedException {
			driver.findElement(amount).sendKeys(amount1);
			driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		}
		
		//For clicking Next Button:
		public void clickNext() throws InterruptedException {
			driver.findElement(giftEnter).click();	
			driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		}
		
		//For entering Recipient Name:
		public void enterRecipientName() throws InterruptedException {
			driver.findElement(recipentName).sendKeys(Recipient_Name);
			driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		}
		
		//For entering Recipient Email:
		public void enterRecipientEmail() throws InterruptedException {
			driver.findElement(recipentMail).sendKeys(Your_Email);	
			driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		}
		
		//For entering Sender Name:
		public void enterSenderName() throws InterruptedException {
			  driver.findElement(senderName).sendKeys(Your_Name);	
			  driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		}
		
		//For entering Sender Number: 
		public void enterSenderNo() throws InterruptedException {
			driver.findElement(senderPhNo).sendKeys(phone);
			driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		}
		
		//For getting error message while entering invalid Sender Email:
		    public void displayErrorMessage() throws InterruptedException, IOException {
			WebElement mail = driver.findElement(mailEnter1);
			mail.sendKeys(Recipient_Email);
			driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		    driver.findElement(mailEnter).click();
				String f= mail.getAttribute("validationMessage");
				driver.findElement(submit).click();
				System.out.println("\n"+"The error message appeared for invalid e-mail: " +f +"\n");
				
				Reporter.log("\n"+"The error message appeared for invalid e-mail: " +f +"\n");
				
			
			}
		    
		  //For Taking ScreenShot of the error alert message:
		    public void takeScreenShot() {
		    	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				try 
				{
					FileHandler.copy(screenshot,
					new File(System.getProperty("user.dir")+"\\screenshot\\giftcard.png"));
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}		
		    }
}
			