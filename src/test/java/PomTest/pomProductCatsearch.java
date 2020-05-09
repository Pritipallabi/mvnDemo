package PomTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Pompages.Browserfactory;
import Pompages.clsEbay;

public class pomProductCatsearch {
  @Test
  public void ProdcatSearch() {
	  
	 WebDriver driver = Browserfactory.Startbrowser("google","http://ebay.com");
	 
	 clsEbay obj = new clsEbay(driver);
	 obj.fnprodcatSearch("Cameras & Photo","sony");
			 
  }
}
