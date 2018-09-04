package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_11_Webdriver_Wait {
	WebDriver driver;
	@BeforeClass
	  public void beforeClass() {
		 
		  
	  }
	
  @Test
  public void TC_01_ImplicitWait() {
	  driver= new FirefoxDriver();
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  driver.manage().timeouts().implicitlyWait(02, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	 WebElement startButton = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
	 startButton.click();
	 
	 WebElement helloText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
	 String text = helloText.getText();
	 
	 
  }
  
  @Test
  public void TC_02() {
	
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
