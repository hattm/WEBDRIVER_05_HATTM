package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_05_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
	}

	@Test
	public void TC_01() throws Exception {
		
	// Jquery
	driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
		 
	selectCustomDropdownList("//span[@id='speed-button']","//ul[@id='speed-menu']//li[@class='ui-menu-item']/div","Slower");
	Assert.assertTrue(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text'and text()='Slower']")).isDisplayed());

	selectCustomDropdownList("//span[@id='number-button']", "//ul[@id='number-menu']//li[@class='ui-menu-item']/div","19");
	Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text'and text()='19']")).isDisplayed());
	
	// Angular
	driver.get("https://material.angular.io/components/select/examples");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	selectCustomDropdownList("//mat-select[@placeholder='Favorite food']","//mat-option/span","Tacos");
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mat-select-value']//span[text()='Tacos']")).isDisplayed());
	
	selectCustomDropdownList("//mat-select[@placeholder='State']","//mat-option/span","Washington");
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mat-select-value']//span[text()='Washington']")).isDisplayed());	
	
	
	// Telerik KendoUI
	driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	
	selectCustomDropdownList("//span[@aria-labelledby='color_label']", "//ul[@id='color_listbox']/li", "Grey");
	Assert.assertTrue(driver.findElement(By.xpath("//span[@aria-labelledby='color_label']//span[@class='k-input' and text()='Grey']/parent::span")).isDisplayed());
	
	selectCustomDropdownList("//span[@aria-labelledby='size_label']", "//ul[@id='size_listbox']/li", "L - 7 1/8\"");
	Assert.assertTrue(driver.findElement(By.xpath("//span[@aria-labelledby='size_label']//span[@class='k-input' and text()='L - 7 1/8\"']/parent::span")).isDisplayed());
	Thread.sleep(3000);
		
	
	// Vuejs
	driver.get("https://mikerodham.github.io/vue-dropdowns/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	selectCustomDropdownList("//div[@class='btn-group']/li", "//div[@class='btn-group']/ul/li", "Third Option");
	Assert.assertTrue(driver.findElement(By.xpath("//li[@class='dropdown-toggle' and contains(text(),'Third Option')]")).isDisplayed());
	
	
	// jquery Editable
	driver.get("http://indrimuska.github.io/jquery-editable-select/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	 selectCustomDropdownList("//select[@id='base']", "//select[@id='base']/option", "Jaguar"); 
	 Assert.assertTrue(driver.findElement(By.xpath("//select[@id='base']/option[text()='Jaguar']")).isDisplayed());

	driver.findElement(By.xpath("//div[@id='basic-place']//input[@type='text']")).clear();
	driver.findElement(By.xpath("//div[@id='basic-place']//input[@type='text']")).sendKeys("Jaguar");
	
	}
	public void selectCustomDropdownList(String dropdown, String listItems, String valueItem) throws Exception {
		// Click vào dropdown
		WebElement dropdownElement = driver.findElement(By.xpath(dropdown));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdownElement);
		dropdownElement.click();
		// Get tất cả item trong dropdown vào 1 list element(List <WebElement>)
		List<WebElement> allItems = driver.findElements(By.xpath(listItems));
		//Wait để tất cả phần tử trong dropdown được hiển thị
		wait.until(ExpectedConditions.visibilityOfAllElements(allItems));
		// Dùng vòng lặp for duyệt qua từng phần tử
		for (WebElement item : allItems) {
			System.out.println(item.getText());
			if (item.getText().trim().equals(valueItem)) {
				// Croll item
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
				Thread.sleep(3000);
				// Nếu actual text = expected text thì click vào phần tử đó và break khỏi vòng lặp
				item.click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
