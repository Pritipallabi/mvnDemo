package Pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserfactory {
	
	public static WebDriver wd;
	
	public static WebDriver Startbrowser(String bname,String url ) {
		
		if(bname.equalsIgnoreCase("google")) {
			
			WebDriverManager.chromedriver().version("81").setup();
			wd = new ChromeDriver();
		}
		
		if(bname.equalsIgnoreCase("firefox")){
			
			WebDriverManager.firefoxdriver().version("75").setup();
			wd = new FirefoxDriver();
		}
		
		wd.manage().window().maximize();
		wd.get(url);
		return wd;
		
	}

}
