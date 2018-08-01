package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_04_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	  public void beforeClass() {
		  driver= new FirefoxDriver();
		  wait = new WebDriverWait(driver,30);
		  
		  driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		  
	  }
	
  @Test
  public void TC_01(){
	  selectCustomDropdownList("//span[@id='speed-button']", "//ul[@id='speed-menu']//li[@class='ui-menu-item']/div", "Fast");
	  Assert.assertTrue(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text' and text()='Faster']")).isDisplayed());
	  selectCustomDropdownList("//span[@id='number-button]", "//ul[@id='number-menu']//li[@class='ui-menu-item']/div", "19");
	  Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='19']")).isDisplayed());
	 
	  
  }
  
  
  public void selectCustomDropdownList(String dropdown, String listItems, String valueItem)  {
	  // Click vào dropdown
	  driver.findElement(By.xpath(dropdown)).click();
	  
	  // Get tất cả item trong dropdown vào 1 list element (List <WebElement>)
	  List<WebElement>allItems= driver.findElements(By.xpath(listItems));
	  
	  //Wait để tất cả phần tử trong dropdown được hiển thị
	  wait.until(ExpectedConditions.invisibilityOfAllElements(allItems));
	  
	  // Dùng vòng lặp for duyệt qua từng phần tử 
	  for(WebElement item: allItems) {
		  System.out.println(item.getText());
		  if(item.getText().equals(valueItem)) {
			  // Croll item
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",item);
			
			  // Nếu actual text = expected text thì click vào phần tử đó và break khỏi vòng lặp
			  item.click();
			  break;
		  }	  
	  }	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
