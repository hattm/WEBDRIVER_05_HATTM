package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_10_UploadFile {
	WebDriver driver;
	String projectDirectory = System.getProperty("user.dir");
	String fileName = "Upload.png";
	String fileName_02 = "02.png";
	String fileName_03 = "03.png";
	String uploadFilePath00 = projectDirectory + "\\imges\\" + fileName;
	String uploadFilePath01 = projectDirectory + "\\imges\\" + fileName_02;
	String uploadFilePath02 = projectDirectory + "\\imges\\" + fileName_03;
	
	String chromeUpload = projectDirectory + "\\upload\\chrome.exe";
	String firefoxUpload = projectDirectory + "\\upload\\firefox.exe";
	String ieUpload = projectDirectory + "\\upload\\ie.exe";
	String folderName = "authattm" + randomNumer();
	String email = "authattm"+ randomNumer() + "@gmail.com";
	String name = "Automation FC";

	@BeforeClass
	public void beforeClass() {
		/* System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe"); 
		driver = new ChromeDriver();*/
		 

		//driver= new FirefoxDriver();

		System.setProperty("webdriver.ie.driver", ".\\driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	public void TC_01_SendkeysAPI() {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));
		
		uploadElement.sendKeys(uploadFilePath00);

		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());
	
		driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[@title='" + fileName + "']")).isDisplayed());
		

	}
	
	public void TC_02_AutoIT() throws IOException, Exception {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		// Chrome/ Firefox/ IE
		WebElement uploadElement = driver.findElement(By.cssSelector(".fileinput-button"));
		uploadElement.click();
		
		 //Runtime.getRuntime().exec(new String[] { chromeUpload, uploadFilePath00 });
		 //Runtime.getRuntime().exec(new String[] { firefoxUpload, uploadFilePath00 });
		 Thread.sleep(3000);
		Runtime.getRuntime().exec(new String[] { ieUpload, uploadFilePath00 });

		// verify uploaded
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());
		
		driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[@title='" + fileName + "']")).isDisplayed());
		
	}
	
	public void TC_03_Robot() throws Exception {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		// Defile location of fileName
		StringSelection select = new StringSelection(uploadFilePath00);

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
	public void TC_04_UploadFileChucker() {

		driver.get("https://encodable.com/uploaddemo/");

		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(uploadFilePath00);

		WebElement uploadDropdown = driver.findElement(By.xpath("//select[@name='subdir1']"));
		Select select = new Select(uploadDropdown);
		select.selectByVisibleText("/uploaddemo/files/");

		driver.findElement(By.xpath("//input[@id='newsubdir1']")).sendKeys(folderName);
		driver.findElement(By.xpath("//input[@id='formfield-email_address']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='formfield-first_name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='uploadbutton']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//dl[@id='fcuploadsummary']//dd[text()='Email Address: " + email + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//dl[@id='fcuploadsummary']//dd[text()='First Name: " + name + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//dl[@id='fcuploadsummary']//dt[contains(text(),'File 1 of 1')]//a[text()='"+ fileName + "']")).isDisplayed());
		
		driver.findElement(By.xpath("//a[text()='View Uploaded Files']")).click();
		driver.findElement(By.xpath("//a[text()='"+ folderName +"']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ fileName + "']")).isDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumer() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
