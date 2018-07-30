package selenium_api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Textbox_TextArea_DropdowList {
	WebDriver driver;
	By nameTextbox= By.xpath("//a[text()='New Customer']");
	By dobTextbox = By.xpath("//input[@id='dob']");
	By addressTextArea= By.xpath("//textarea[@name='addr']");
	By cityTextbox = By.xpath("//input[@name='city']");
	By stateTextbox = By.xpath("//input[@name='state']");
	By pinTextbox = By.xpath("//input[@name='pinno']");
	By phoneTextbox = By.xpath("//input[@name='telephoneno']");
	By emailTextbox = By.xpath("//input[@name='emailid']");
	By passwordTextbox = By.xpath("//input[@name='password']");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public void TC_01_DropDowList() throws InterruptedException {
		driver.get("http://daominhdam.890m.com/");
		
		Select jobRole = new Select(driver.findElement(By.xpath("//select[@id='job1']")));
		
		Assert.assertTrue(!jobRole.isMultiple());
		
		jobRole.selectByVisibleText("Automation Tester");
		Assert.assertEquals(jobRole.getFirstSelectedOption().getText(), "Automation Tester");
		Thread.sleep(5000);
		
		jobRole.selectByValue("manual");
		Assert.assertEquals(jobRole.getFirstSelectedOption().getText(), "Manual Tester");
		
		jobRole.selectByIndex(3);
		Assert.assertEquals(jobRole.getFirstSelectedOption().getText(), "Mobile Tester");
		
		int jobItems= jobRole.getOptions().size();
		Assert.assertEquals(jobItems, 5);

	}

	@Test
	public void TC_02_Textbox_TextArea() {
		driver.get("http://demo.guru99.com/v4");
		
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr145853");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("henEbar");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
		
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		
		


	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
