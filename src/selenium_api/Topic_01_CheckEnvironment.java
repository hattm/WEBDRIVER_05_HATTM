package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_01_CheckEnvironment {
	WebDriver driver;
	
  @Test
  public void TC_01_CheckUrlAndTitle() {
	
	  String homePageTitile= driver.getTitle();
	  Assert.assertEquals(homePageTitile, "Guru99 Bank Home Page");
	  System.out.println("Check homePage title");
	
	  
	  System.out.println("Check homePage url");
	  String homePageUrl = driver.getCurrentUrl();
	  Assert.assertEquals(homePageUrl, "http://demo.guru99.com/v4/");
  }
  @BeforeClass
  public void beforeClass() {
	  driver= new FirefoxDriver();
	  driver.get("http://demo.guru99.com/v4");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
