package utilities_package;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Utilities {
	
	public static WebDriver driver;
  
  @AfterMethod
  public void afterMethod() {
  }
  
  @Parameters({"browserName","urlAddress"})
  @BeforeClass
  public void browserInitialization(String browser, String url) {
	  
	String UD =  System.getProperty("user.dir");
	
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", UD+"drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
	  
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
