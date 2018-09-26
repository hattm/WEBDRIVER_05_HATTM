package selenium_api;

import org.testng.annotations.Test;

import com.google.common.base.Function;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_11_Webdriver_Wait_Example {
	WebDriver driver;
	WebDriverWait waitExplicit;
	@BeforeClass
	  public void beforeClass() {
		  driver= new FirefoxDriver();
		  waitExplicit = new WebDriverWait(driver,40);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
	  }
	

  public void TC_01() {
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  
	  // wait 2s để click start button
	  driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
	  
	  // Mất 5s để click vào Start button 
	  
	  // wait 2s để getText
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(),"Hello World!");
  }
  @Test
  public void TC_02() {
	  driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
	  
	  //Step 02 - Wait cho "Date Time Picker" được hiển thị (sử dụng: presence or visibility)
	  /*Presence*/
	  waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='contentWrapper']")));
	  
	  /*Visible*/
	  waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='contentWrapper']")));
	  
	  /*Presence-> Pass*/
	  //Ajax icon loading 
	  waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='raDiv']")));
	
	  /*Issuse 01- Visible-> Fail*/
	//  waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));  
	  
	  //Step 03 - In ra ngày đã chọn (Before AJAX call) -> hiện tại chưa chọn nên in ra = "No Selected Dates to display."
	  WebElement todayBefore = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']"));
	  Assert.assertEquals(todayBefore .getText(), "No Selected Dates to display.");
	  
	  String today = "9/Oct/2020";
	  //Step 04 - Chọn ngày hiện tại (VD: 23/09/2017) (hoặc 1 ngày bất kì tương ứng trong tháng/ năm hiện tại)
	 // driver.findElement(By.xpath("//a[text()='13']/parent::td")).click();
	  selectDateInDTP(today);
	  
	  //Issuse 02: Step 05 - Wait cho đến khi "loader ajax" không còn visible (sử dụng: invisibility)
	 waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
	  
	  // Step 06 - Wait cho selected date = 23 được visible ((sử dụng: visibility)
	  waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='9']/parent::td[@class='rcSelected']")));
	  Assert.assertTrue(driver.findElement(By.xpath("//a[text()='9']/parent::td[@class='rcSelected']")).isDisplayed());
	  
	  /*//Issuse 03: Step 07 - Verify ngày đã chọn bằng = Saturday, September 23, 2017
	  WebElement todayAfter = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']"));
	  Assert.assertEquals(todayAfter.getText(), "Sunday, September 09, 2018");*/
  }
  
  public void selectDateInDTP(String date) {
	  String [] array = date.split("/");
	  String day = array[0];
	  String month = array[1];
	  String year = array[2];
	  
	  WebElement monthYearTitile = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceholder1_RadCalendar1_Title']"));
	  Actions action = new  Actions(driver);
	  action.contextClick(monthYearTitile).perform();
	  
	  waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@id,'rcMView')]/a[text()='"+ year +"']")));
	  driver.findElement(By.xpath("//td[contains(@id,'rcMView')]/a[text()='"+ year +"']")).click();
	  
	  waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@id,'rcMView')]/a[text()='"+ month +"']")));
	  driver.findElement(By.xpath("//td[contains(@id,'rcMView')]/a[text()='"+ month +"']")).click();
	  driver.findElement(By.xpath(".//*[@id='rcMView_OK']")).click();
	  waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
	  
	  if(Integer.parseInt(day) < 10) {
		  day = day.replace("0", "");
		  System.out.println(day);
	  }
	  
	  driver.findElement(By.xpath("//a[text()='"+ day +"']/parent::td")).click();
	  waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
  }
  
  public String convertMonthNumberToString(int month) {
	  String monthText = " ";
	  switch (month) {
	  case 01: 
		  monthText ="Jan";
		  break;
	  case 02: 
		  monthText ="Feb";
		  break;
	  case 03: 
		  monthText ="Mar";
	  case 04: 
		  monthText ="Apr";
		  break;
	  case 05: 
		  monthText ="May";
		  break;
	  case 06: 
		  monthText ="Jun";
		  break;
	 default: 
		 monthText = "";
	  
	  }
	  return monthText;
  }

  public void TC_03() {
	  driver.get("https://daominhdam.github.io/fluent-wait/");
	  
	  WebElement countDount = driver.findElement(By.xpath("//div[@id='javascript_countdown_time']"));
	  
	// Khởi tạo Fluent wait
	  new FluentWait<WebElement>(countDount)
	             // Tổng time wait là 15s
	             .withTimeout(12, TimeUnit.SECONDS)
	              // Tần số mỗi 1/10 s check 1 lần
	              .pollingEvery(1, TimeUnit.SECONDS)
	             // Nếu gặp exception là find ko thấy element sẽ bỏ  qua
	              .ignoring(NoSuchElementException.class)
	              // Kiểm tra điều kiện
	              .until(new Function<WebElement, Boolean>() {
	                  public Boolean apply(WebElement element) {
	                             // Kiểm tra điều kiện countdount = 00
	                             boolean flag =  element.getText().endsWith("00");
	                             System.out.println("Time = " +  element.getText());
	                             // return giá trị cho function apply
	                             return flag;
	                        }
	                 });
	  
	 
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
