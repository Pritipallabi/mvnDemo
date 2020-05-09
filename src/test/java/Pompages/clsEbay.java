package Pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class clsEbay {
	
	public WebDriver wd;
	
	public clsEbay(WebDriver d) {
		
		wd = d;
	}
	
	By txtsearch = By.id("gh-ac");
	By btnsearch = By.id("gh-btn");
	By ddcat = By.id("gh-cat");
	
	public void fnprodSearch(String prodname) {
		
		wd.findElement(txtsearch).sendKeys("sony");
		wd.findElement(btnsearch).click();
		
	}
	
	public void fnprodcatSearch(String cat,String pname) {
		
		WebElement dd = wd.findElement(ddcat);
		Select s = new Select(dd);
	    s.selectByVisibleText(cat);
	    fnprodSearch(pname);
		
		
	}

}
