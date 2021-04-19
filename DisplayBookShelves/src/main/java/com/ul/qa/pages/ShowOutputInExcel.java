package com.ul.qa.pages;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
public class ShowOutputInExcel {



	public void showStudyChairDetailsInExcelFile(List<WebElement> name, List<WebElement> price) throws Exception
	{
		
		
		
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(); 
	    // Create a blank sheet 
	    XSSFSheet sheet = workbook.createSheet("StudyChairs"); 
	    TreeMap<String, Object[]> data = new TreeMap<String, Object[]>(); 
	    data.put("1", new Object[]{ "Name",  "Price (Rs)"}); 
	    for(int i=0; i<3; i++)
	    	data.put(Integer.toString(i+2), new Object[]{name.get(i).getText(), price.get(i).getText()}); 

	    // Iterate over data and write to sheet 
	    Set<String> keyset = data.keySet(); 
	    int rownum = 0; 
	    for (String key : keyset)
	    { 
	        // this creates a new row in the sheet 
	        XSSFRow row = sheet.createRow(rownum++); 
	        Object[] objArr = data.get(key); 
	        int cellnum = 0; 
	        for (Object obj : objArr) 
	        { 
	            // this line creates a cell in the next column of that row 
	            XSSFCell cell = row.createCell(cellnum++); 
	            if (obj instanceof String) 
	                cell.setCellValue((String)obj); 
	            else if (obj instanceof Integer) 
	                cell.setCellValue((Integer)obj); 
	        } 
	    }   
	    try 
	    { 
	        // this Writes the workbook
	        FileOutputStream out = new FileOutputStream(new File("StudyChairsDetails.xlsx")); 
	        workbook.write(out); 
	        out.close(); 
	        System.out.println("StudyChairsDetails.xlsx written successfully on disk."); 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	}
	public void showBookshelvesInExcelFile(List<WebElement> names,  List<WebElement> prices) throws Exception
	{
		
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(); 
	    // Create a blank sheet 
	    XSSFSheet sheet = workbook.createSheet("Bookshelves"); 
	    TreeMap<String, Object[]> data = new TreeMap<String, Object[]>(); 
	    data.put("1", new Object[]{ "Name",  "Price (Rs)"}); 
	    for(int i=0; i<3; i++)
	    	data.put(Integer.toString(i+2), new Object[]{names.get(i).getText(), prices.get(i).getText()}); 

	    // Iterate over data and write to sheet 
	    Set<String> keyset = data.keySet(); 
	    int rownum = 0; 
	    for (String key : keyset)
	    { 
	        // this creates a new row in the sheet 
	        XSSFRow row = sheet.createRow(rownum++); 
	        Object[] objArr = data.get(key); 
	        int cellnum = 0; 
	        for (Object obj : objArr) 
	        { 
	            // this line creates a cell in the next column of that row 
	            XSSFCell cell = row.createCell(cellnum++); 
	            if (obj instanceof String) 
	                cell.setCellValue((String)obj); 
	            else if (obj instanceof Integer) 
	                cell.setCellValue((Integer)obj); 
	        } 
	    }   
	    try 
	    { 
	        // this Writes the workbook
	        FileOutputStream out = new FileOutputStream(new File("BookshelvesDetails.xlsx")); 
	        workbook.write(out); 
	        out.close(); 
	        System.out.println("BookshelvesDetails.xlsx written successfully on disk."); 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	}
	
	public void showMenuInExcel(List<String> listitem)
	{
	
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(); 
	    // Create a blank sheet 
	    XSSFSheet sheet = workbook.createSheet("MenuList"); 
	    TreeMap<String, Object[]> data = new TreeMap<String, Object[]>(); 
	    data.put("1", new Object[]{ "ListItems"}); 
	    for(int i=0; i<13; i++)
	    	data.put(Integer.toString(i+2), new Object[]{listitem.get(i)}); 

	    // Iterate over data and write to sheet 
	    Set<String> keyset = data.keySet(); 
	    int rownum = 0; 
	    for (String key : keyset)
	    { 
	        // this creates a new row in the sheet 
	        XSSFRow row = sheet.createRow(rownum++); 
	        Object[] objArr = data.get(key); 
	        int cellnum = 0; 
	        for (Object obj : objArr) 
	        { 
	            // this line creates a cell in the next column of that row 
	            XSSFCell cell = row.createCell(cellnum++); 
	            if (obj instanceof String) 
	                cell.setCellValue((String)obj); 
	            else if (obj instanceof Integer) 
	                cell.setCellValue((Integer)obj); 
	        } 
	    }   
	    try 
	    { 
	        // this Writes the workbook
	        FileOutputStream out = new FileOutputStream(new File("MenuList.xlsx")); 
	        workbook.write(out); 
	        out.close(); 
	        System.out.println("MenuList.xlsx written successfully on disk."); 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	}
	/*public void showGiftCardInExcel(String f) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(); 
	    // Create a blank sheet 
	    XSSFSheet sheet = workbook.createSheet("GiftCardMessage"); 
	    //int size = listitem.size();
	    Row rowdata=sheet.createRow(0);
	    Date message = null;
	    rowdata.createCell(0).setCellValue(message);
	    File file=new File("GiftCard.xlsx");
	    FileOutputStream output= new FileOutputStream(file);
	    workbook.write(output);
	    output.close();
		
	}*/
	
	


	
}

