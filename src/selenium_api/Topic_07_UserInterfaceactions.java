package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_07_UserInterfaceactions {
	WebDriver driver;
	@BeforeClass
	  public void beforeClass() {
		  driver= new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
	  }
	
  public void TC_01_HoverMousce() throws Exception {
	  driver.get(" http://daominhdam.890m.com/");  
	WebElement hoverText= driver.findElement(By.xpath("//a[text()='Hover over me']"));
	
	// Usert Interaction -> Actions
	Actions action = new Actions(driver);
	
	// Hover Mouse
	action.moveToElement(hoverText).perform();
	Thread.sleep(5000);
	
	// Verify tooltip displayed
	Assert.assertEquals(driver.findElement(By.xpath("//div[@role='tooltip']//div[@class='tooltip-inner']")).getText(), "Hooray!");
	
	
  }
  
  
  public void TC_02_ClickAndHold() throws Exception {
	  driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
	  
	  List<WebElement>selectable = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));
	
	  // List/ Array: start index = 0-> n-1
	 /* Actions action =  new Actions(driver);
	  
	  action.clickAndHold(selectable.get(0)).moveToElement(selectable.get(7)).release().perform();
	  
	  List<WebElement>selectedtable = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));
	  Assert.assertEquals(selectedtable.size(),8);*/
	  
	  Actions action = new Actions(driver);
	  
	  // Giả lập nhân phím Ctrl xuống
	  action.keyDown(Keys.CONTROL).build().perform();
	  
	  selectable.get(0).click();
	  selectable.get(2).click();
	  selectable.get(4).click();
	  selectable.get(7).click();
	  selectable.get(11).click();
	  
	  // Giả lập nhã phím Ctrl ra
	  action.keyUp(Keys.CONTROL).build().perform();
	  
	  Thread.sleep(5000);
	  List<WebElement>selectedtable = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));
	  Assert.assertEquals(selectedtable.size(),5);
	  
  }
  
  public void TC_03_DoubleClick() throws Exception {
	driver.get("http://www.seleniumlearn.com/double-click");
	
	WebElement doubleClickText= driver.findElement(By.xpath("//button[text()='Double-Click Me!']"));
	Actions action = new Actions(driver);
	
	// Giả lập hành động double click 
	action.doubleClick(doubleClickText).perform();
	Thread.sleep(5000);
	
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "The Button was double-clicked.");
	alert.accept();
	
	
  }

  @Test
  public void TC_04_RighClick() {
	  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	  
	 WebElement righClikButton =  driver.findElement(By.xpath("//span[text()='right click me']"));
	 
	 Actions action = new Actions(driver);
	 
	 // Right Click
	 action.contextClick(righClikButton).perform();
	 
	 
	 WebElement quitBefore = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]"));
	 // Hover to Quit
	 action.moveToElement(quitBefore).perform();
	 
	 // Verify hover success
	 Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') and contains(@class,'context-menu-hover') and contains(@class,'context-menu-visible')]")).isDisplayed());
	 
	 // Click to Quit
	 action.click(quitBefore).perform();
	 
	 Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "clicked: quit");
		alert.accept();
	
  }

  public void TC_05() {
	
  }
  
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
