package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_10_UploadFile {
	WebDriver driver;
	String projectDirectory = System.getProperty("user.dir");
	String fileName = "Upload.png";
	String uploadFilePath = projectDirectory + "\\imges\\" + fileName;
	String chromeUpload = projectDirectory + "\\upload\\chrome.exe";
	String firefoxUpload = projectDirectory + "\\upload\\firefox.exe";
	String ieUpload = projectDirectory + "\\upload\\ie.exe";

	@BeforeClass
	public void beforeClass() {
		
		 /* System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe"); 
		  driver = new ChromeDriver();
		 */

		//driver= new FirefoxDriver();

		System.setProperty("webdriver.ie.driver", ".\\driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println(uploadFilePath);
	}

	public void TC_01_SendkeysAPI() {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));
		uploadElement.sendKeys(uploadFilePath);

		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());

		driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[@title='" + fileName + "']")).isDisplayed());

	}

	public void TC_02_AutoIT() throws IOException, Exception {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		// Chrome/ Firefox/ IE
		WebElement uploadElement = driver.findElement(By.cssSelector(".fileinput-button"));
		uploadElement.click();

		// Runtime.getRuntime().exec(new String[] { chromeUpload, uploadFilePath });
		// Runtime.getRuntime().exec(new String[] { firefoxUpload, uploadFilePath });
		Runtime.getRuntime().exec(new String[] { ieUpload, uploadFilePath });

		// verify uploaded
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());
		driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[@title='" + fileName + "']")).isDisplayed());
	}

	public void TC_03_Robot() throws Exception {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		// Defile location of fileName
		StringSelection select = new StringSelection(uploadFilePath);

		// Copy location to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		
		// Chrome/ Firefox/ IE
		WebElement uploadElement = driver.findElement(By.cssSelector(".fileinput-button"));
		uploadElement.click();
		Thread.sleep(3000);
		
		Robot robot = new Robot();	

		// Focus to textbox
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Giả lập phím nhấn xuống Ctrl-V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		// Giả nhả phím nhấn xuống Ctrl-V ra
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		
		
		// Nhấn Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		// verify uploaded
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());
		driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[@title='" + fileName + "']")).isDisplayed());
	}

	@Test
	public void TC_04_Robot() {
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
