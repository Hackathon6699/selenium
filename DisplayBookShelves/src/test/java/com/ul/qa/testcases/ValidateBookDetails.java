package com.ul.qa.testcases;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ul.qa.base.TestBase;
import com.ul.qa.pages.CollectionSubMenuPage;
import com.ul.qa.pages.DisplayBookShelvesPage;
import com.ul.qa.pages.GiftCardPage;

public class ValidateBookDetails extends TestBase{
	
	 @BeforeClass(groups = "Smoke Test")
	
	 //This method is used to invoking driver
	 public void initialiseSetUp() throws IOException {
		  Properties prop = TestBase.setProperties();
		  String browser = prop.getProperty("browser");
		  driver=TestBase.driverInstantiate(browser);
		  driver.get(prop.getProperty("url"));
		  driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		  
	  }
	 @Test(priority = 1,groups="Regression Test")
	 //This method is use to call the 'validateHomePageTitle' method
	  public void homePageTitleTest() throws Exception {
		   DisplayBookShelvesPage homepage = new DisplayBookShelvesPage(driver);
		 //Use of Assert Function 
		 String title=homepage.validateHomePageTitle();
		 Assert.assertEquals(title, "Furniture Online: @Upto 40% Off on Wooden Furniture Online in India at Best Price - Urban Ladder");
		   
	  }
	  @Test(priority = 2,groups="Smoke Test")//This method is use to call the 'closePopup' method
	  
	  public void closePopUpTest() throws Exception {
		  DisplayBookShelvesPage homepage = new DisplayBookShelvesPage(driver);
		  homepage.closePopup();
	  }
		  
	 @Test(priority = 3,groups="Smoke Test")
	 //This method is use to call the 'searchBox' method
	  public void searchBoxTest() throws Exception {
		  DisplayBookShelvesPage homepage = new DisplayBookShelvesPage(driver);
		  homepage.searchBox("BookShelves");
		  
	  }
	 @Test(priority = 4,groups="Smoke Test")
	 //This method is use to call the 'clickOnSearchButton' method
	 public void searchButtonTest() throws InterruptedException {
		 DisplayBookShelvesPage homepage = new DisplayBookShelvesPage(driver);
		 homepage.clickOnSearchButton();
		 
	 }
	 @Test(priority = 5,groups="Smoke Test")
	 //This method is use to call the 'setCategory' method
	 public void categoryTest() throws InterruptedException {
		 DisplayBookShelvesPage homepage = new DisplayBookShelvesPage(driver);
		 homepage.setCategory();
	 }
	 @Test(priority =6 ,groups="Smoke Test")
		//This method is use to call the 'setStorageType' method
		 public void amountTest() throws InterruptedException {
			 DisplayBookShelvesPage homepage = new DisplayBookShelvesPage(driver);
			 homepage.selectPrice();
		 
	 }
		 @Test(priority = 7,groups="Smoke Test")
		//This method is use to call the 'setStorageType' method
		 public void storageTypeTest() throws InterruptedException {
			 DisplayBookShelvesPage homepage = new DisplayBookShelvesPage(driver);
			 homepage.setStorageType();
		 
	 }
		 @Test(priority = 8,groups="Smoke Test")
		 //This method is use to call the 'clickOutOfStock' method
		 public void outOfStockTest() throws InterruptedException {
			 DisplayBookShelvesPage homepage = new DisplayBookShelvesPage(driver);
			 homepage.clickOutOfStock();
		 }
		
		 
		 @Test(priority = 9 ,groups="Smoke Test")
			//This method is use to call the 'takeScreenShot' method
			  public void screenShotTest1() throws InterruptedException {
				   
			 DisplayBookShelvesPage bookshelvespage = new DisplayBookShelvesPage(driver);
			 bookshelvespage.takeScreenShot();
			  }
		 @Test(priority = 10,groups="Smoke Test")
		 //This method is use to call the 'getBookDetails' method
		 public void bookDetailsTest() throws Exception {
			 DisplayBookShelvesPage homepage = new DisplayBookShelvesPage(driver);
			 homepage.getBookDetails();
	 
         }
		 @Test(priority = 11,groups="Smoke Test")
			//This method is use to call the 'clickOnCollection' method
			 public void CollectionButtonTest() throws InterruptedException {
				 CollectionSubMenuPage collectionsubmenupage = new CollectionSubMenuPage(driver);
				 collectionsubmenupage.clickOnCollection();
				
				 
			 }
			 
			 @Test(priority = 12,groups="Smoke Test")
			//This method is use to call the 'displaySubmenu' method
			 public void subMenuTest() throws Exception {
				 CollectionSubMenuPage collectionsubmenupage = new CollectionSubMenuPage(driver);
				 collectionsubmenupage.displaySubmenu();
				 
			 }
			 @Test(priority = 13,groups="Smoke Test")
				//This method is use to call the 'clickOnCollection' method
				 public void studyChairsTest() throws InterruptedException {
					 CollectionSubMenuPage collectionsubmenupage = new CollectionSubMenuPage(driver);
					 collectionsubmenupage.studyChairs();
					
					 
				 }
			
			 @Test(priority = 14,groups="Smoke Test")
				//This method is use to call the 'clickOnCollection' method
				 public void studyChairsDisplayTest() throws Exception {
					 CollectionSubMenuPage collectionsubmenupage = new CollectionSubMenuPage(driver);
					 collectionsubmenupage.getChairsDetails();
							
			 }
			 
			 @Test(priority = 15 ,groups="Smoke Test")
				//This method is use to call the 'takeScreenShot' method
				  public void screenShotTest2() throws InterruptedException {
					   
				 CollectionSubMenuPage collectionsubmenupage = new CollectionSubMenuPage(driver);
				 collectionsubmenupage.takeScreenShot2();
				  }
			 @Test(priority = 16,groups="Smoke Test" )
			  //This method is use to call the 'clickOnGiftCard' method
			  public void GiftCardButtonTest() throws Exception {
				   
				   GiftCardPage giftcardpage = new GiftCardPage(driver);
				   giftcardpage.clickOnGiftCard();
			  }
			  @Test(priority = 17 ,groups="Smoke Test")
			  //This method is use to call the 'selectCard' method
			  public void selectCardTest() throws Exception {
				   
				   GiftCardPage giftcardpage = new GiftCardPage(driver);
				   giftcardpage.selectCard();
			  }
			  @Test(priority = 18 ,groups="Smoke Test")
			//This method is use to call the 'setAmount' method
			  public void AmountTextBoxTest() throws Exception {
				   
				   GiftCardPage giftcardpage = new GiftCardPage(driver);
				   giftcardpage.setAmount();
			  }
			  @Test(priority = 19,groups="Smoke Test")
			  //This method is use to call the 'enterRecipientName' method
			  public void RecipientNameTest() throws Exception {
				   
				   GiftCardPage giftcardpage = new GiftCardPage(driver);
				   giftcardpage.enterRecipientName();
			  }
			  @Test(priority = 20,groups="Smoke Test" )
			  //This method is use to call the 'enterRecipientEmail' method
			  public void RecipientEmailTest() throws Exception {
				   
				   GiftCardPage giftcardpage = new GiftCardPage(driver);
				   giftcardpage.enterRecipientEmail();
			  }
			  @Test(priority = 21,groups="Smoke Test" )
			//This method is use to call the 'enterSenderName' method
			  public void senderNameTest() throws Exception {
				   
				   GiftCardPage giftcardpage = new GiftCardPage(driver);
				   giftcardpage.enterSenderName();
			  }
			  @Test(priority = 22 ,groups="Smoke Test")
			//This method is use to call the 'enterSenderNo' method
			  public void senderNoTest() throws Exception {
				   
				   GiftCardPage giftcardpage = new GiftCardPage(driver);
				   giftcardpage.enterSenderNo();
			  }
			  @Test(priority = 23,groups="Smoke Test" )
			//This method is use to call the 'displayErrorMessage' method
			  public void errorMessageTest() throws Exception {
				   
				   GiftCardPage giftcardpage = new GiftCardPage(driver);
				   giftcardpage.displayErrorMessage();
			  }
			  
			  @Test(priority = 24 ,groups="Smoke Test")
			//This method is use to call the 'takeScreenShot' method
			  public void screenShotTest() throws Exception {
				   
				   GiftCardPage giftcardpage = new GiftCardPage(driver);
				   giftcardpage.takeScreenShot();
			  }
		 @AfterClass(groups="Smoke Test")
		 //This method is use to quit the driver
		  public void tearDown() {
		  	  driver.quit();
		  }
		  


}
