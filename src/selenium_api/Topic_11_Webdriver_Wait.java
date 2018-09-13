package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;

public class Topic_11_Webdriver_Wait {
	WebDriver driver;
	WebDriverWait wait;
	String email = "mongha2403@gmail.com", password = "123456";

	@BeforeMethod
	public void Method() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_ImplicitWait() {

		// Wait for element/elements visible-> failed
		driver.get("http://live.guru99.com/index.php/customer/account/login/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		driver.findElement(By.xpath("//a/span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click(); // 0.5s
		// 5s sau nó mới load ra ngoài Homepage lại
		driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).click();

	}

	@Test
	public void TC_02() {

		driver.get("http://live.guru99.com/index.php/customer/account/login/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='send2']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/span[text()='Account']")));
		driver.findElement(By.xpath("//a/span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));
		driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).click();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
