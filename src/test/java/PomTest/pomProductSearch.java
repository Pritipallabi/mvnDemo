package PomTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pompages.Browserfactory;
import Pompages.clsEbay;

public class pomProductSearch {
  @Test
  public void Prodsearch() {
	  
	 WebDriver driver = Browserfactory.Startbrowser("Google","http://ebay.com");
	 
	 clsEbay obj = new clsEbay(driver);
	 obj.fnprodSearch("sony");
  }
}
