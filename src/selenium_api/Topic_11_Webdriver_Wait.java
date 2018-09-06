package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Topic_11_Webdriver_Wait {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	  public void beforeClass() {
		 
		  
	  }
	
  @Test
  public void TC_01_ImplicitWait() {
	  driver= new FirefoxDriver();
	  wait =  new WebDriverWait(driver,30);
	  driver.manage().timeouts().implicitlyWait(02, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	 WebElement startButton = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
	 startButton.click();
	 
	 WebElement helloText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
	 String text = helloText.getText();
	 
	// Wait for element/elements visible
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

	  // Wait for element/elements presence
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

	  // Wait for element/elements invisible
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));
	  
	  List <WebElement> elements = driver.findElements(By.xpath(""));
	  wait.until(ExpectedConditions.invisibilityOfAllElements(elements));

	  // Wait for element/elements clickable
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

	  // Wait for an Alert presence
	  wait.until(ExpectedConditions.alertIsPresent());
	 
	 
  }
  
  @Test
  public void TC_02() {
	
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
