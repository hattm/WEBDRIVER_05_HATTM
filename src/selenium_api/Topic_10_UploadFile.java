package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

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
		 driver = new ChromeDriver();*/
		 
		// driver= new FirefoxDriver();

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

	@Test
	public void TC_02_AutoIT() throws IOException {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		WebElement uploadElement = driver.findElement(By.cssSelector(".fileinput-button"));
		uploadElement.click();

		// Runtime.getRuntime().exec(new String[] { chromeUpload, uploadFilePath });
		//Runtime.getRuntime().exec(new String[] { firefoxUpload, uploadFilePath });
		Runtime.getRuntime().exec(new String[] { ieUpload, uploadFilePath });

		// verify uploaded
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());
		driver.findElement(By.xpath("//table//button[@class='btn btn-primary start']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']//a[@title='" + fileName + "']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
