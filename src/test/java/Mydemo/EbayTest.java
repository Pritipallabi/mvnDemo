package Mydemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayTest {
  @Test
  public void Search() {
	  
	  WebDriverManager.chromedriver().version("81").setup();
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://ebay.com");
	  
	  driver.findElement(By.id("gh-ac")).sendKeys("LG");
	  driver.findElement(By.id("gh-btn")).click();
  }
}
