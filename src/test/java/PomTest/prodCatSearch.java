package PomTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class prodCatSearch {
  @Test
  public void catSearch() {
	  
	  WebDriverManager.chromedriver().version("81").setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://ebay.com");
	  driver.findElement(By.id("gh-ac")).sendKeys("sony");
	  WebElement element =driver.findElement(By.id("gh-cat"));
	  Select s = new Select(element);
	  s.selectByVisibleText("Cameras & Photo");
	  driver.findElement(By.id("gh-btn")).click();
	  
  }
}
