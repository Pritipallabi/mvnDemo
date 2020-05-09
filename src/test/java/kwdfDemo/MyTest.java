package kwdfDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTest {
	public WebDriver driver;
	
  @Test
  public By LocaterInfo(String locType,String locValue) {
	  
	  By b = null;
	  switch(locType) {
	  
	  case "id":
		 b= By.id(locValue);
		  break;
		  
	  case "name":
		 b = By.name("locValue");
		 break;
		 
	  case "className": 
		  b=By.className(locValue);
		  break;
		  
	  case "Xpath": 
		  b=By.xpath(locValue);
		  break;
		  
	  case "tagName": 
		  b=By.tagName(locValue);
		  break;
		  
	  case "cssSelector": 
		  b=By.cssSelector(locValue);
		  break;
		  
	  case "linktext": 
		  b=By.linkText(locValue);
		  break;
		  
	  case "partiallinktext": 
		  b=By.partialLinkText(locValue);
		  break;	  
		  
	  }
	  
	  
	  return b;
  }
  
  @Test
  public void SampleTest()throws Exception {
	  
	  File src = new File("C:\\Users\\priti\\Documents\\Custom Office Templates\\keywords-ebay.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	   
	  XSSFWorkbook wb= new XSSFWorkbook(fis);
	  XSSFSheet sheet = wb.getSheetAt(0);
	  XSSFSheet ws = wb.getSheet("test");
	  
	  Iterator<Row> itr = sheet.iterator();
	  while (itr.hasNext()) {
		Row row = itr.next();
		Iterator<Cell> cellItr = row.cellIterator();
		while(cellItr.hasNext()) {
			Cell cell = cellItr.next();
			String cTestcase = cell.getStringCellValue();
			// String cTestcase = ws.getRow(rows).getCell(0).getStringCellValue();
			  String clocName = cell.getStringCellValue();
			  String clocValue = cell.getStringCellValue();
			  String ctestData = cell.getStringCellValue();
			
//		}
//		
//	}
//Row row=sheet.getRow(vRow); //returns the logical row  
//	  Cell cell=row.getCell(vColumn); //getting the cell representing the given column  
//	  value=cell.getStringCellValue();    //getting cell value
	  
//	 int rows = ws.getPhysicalNumberOfRows();
//	 
//	 for(int i = 1;i<rows; i++) {
		 
//	  String cTestcase = ws.getRow(rows).getCell(0).getStringCellValue();
//	  String clocName = ws.getRow(rows).getCell(1).getStringCellValue();
//	  String clocValue = ws.getRow(rows).getCell(2).getStringCellValue();
//	  String ctestData = ws.getRow(rows).getCell(3).getStringCellValue();
	  
	  switch(cTestcase) {
	  
	   case "open_Browser":
		   if(cTestcase.equalsIgnoreCase("chrome")) {
			   
			   WebDriverManager.chromedriver().version("81").setup();
			   driver = new ChromeDriver();
			   
		   }
		   
		   else if(cTestcase.equalsIgnoreCase("firefox") ){
			   WebDriverManager.firefoxdriver().version("75").setup();
			   driver = new FirefoxDriver();
			   }
		   driver.manage().window().maximize();
		   break;
		   
	   case"enter_Url" :  
		   driver.get(ctestData);
		   break;
		   
	   case"select_Dropdown": 	 
		   
		 WebElement dd=driver.findElement(LocaterInfo(clocName, clocValue));
		 Select s = new Select(dd);
		 s.selectByVisibleText(ctestData);
		 break;
		 
	   case "enter_Text":	 
		   WebElement text=driver.findElement(LocaterInfo(clocName, clocValue));
		   text.sendKeys(ctestData);
		   break;
		   
	   case"click_Button":
		  WebElement btn = driver.findElement(LocaterInfo(clocName, clocValue));
		  btn.click();
		  break;
	   
	  }
	
		}
		}
	
  }
}
