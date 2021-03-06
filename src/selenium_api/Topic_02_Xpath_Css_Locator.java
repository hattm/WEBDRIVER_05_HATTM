package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_Css_Locator {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Check_Navigate_Page() {

		/*
		 * Step 01 - Truy cập vào trang: http://live.guru99.com Step 02 - Kiểm tra title
		 * của page là: "Home page" Step 03 - Click vào link "My Account" để tới trang
		 * đăng nhập Step 04 - Click CREATE AN ACCOUNT button để tới trang đăng kí tài
		 * khoản Step 05 - Back lại trang đăng nhập Step 06 - Kiểm tra url của page đăng
		 * nhập là: http://live.guru99.com/index.php/customer/account/login/ Step 07 -
		 * Forward tới trang tạo tài khoản Step 08 - Kiểm tra url của page tạo tài khoản
		 * là: http://live.guru99.com/index.php/customer/account/create/
		 */
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Home page");

		driver.findElement(By.xpath("//div[@class='footer']//a[text()= 'My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		driver.navigate().back();
		// Về lại page login thành công
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='login-form']")).isDisplayed());

		String loginUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginUrl, "http://live.guru99.com/index.php/customer/account/login/");

		driver.navigate().forward();

		// Về lại register thành công
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='form-validate']")).isDisplayed());

		String registerUrl = driver.getCurrentUrl();
		Assert.assertEquals(registerUrl, "http://live.guru99.com/index.php/customer/account/create/");

	}

	/*
	 * Test Script 05: Create an account Step 01 - Truy cập vào trang:
	 * http://live.guru99.com/ Step 02 - Click vào link "My Account" để tới trang
	 * đăng nhập Step 03 - Click CREATE AN ACCOUNT button để tới trang đăng kí tài
	 * khoản Step 04 - Nhập thông tin hợp lệ vào tất cả các field: First Name/ Last
	 * Name/ Email Address/ Password/ Confirm Password (Lưu ý: Tạo random cho dữ
	 * liệu tại field Email Address) Step 05 - Click REGISTER button Step 05 -
	 * Verify message xuất hiện khi đăng kí thành công: Thank you for registering
	 * with Main Website Store. Step 06 - Logout khỏi hệ thống Step 07 - Kiểm tra hệ
	 * thống navigate về Home page sau khi logout thành công
	 */

	@Test(enabled = false)
	public void TC_05_Create_An_Account() {
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Tran");
		driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Thi Mong");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Ha");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("mongha2403@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456@");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("23456@");

		driver.findElement(By.xpath("//button[@title='Register']")).click();
		driver.findElement(By.xpath("//span[contains(.,'Thank you for registering with Main Website Store')]"));

		driver.findElement(By.xpath("//a[@class='skip-link skip-account skip-active']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();

	}

	@Test(enabled = false)
	public void TC_02_Login_Empty() {
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		String emailErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
		Assert.assertEquals("This is a required field.", emailErrorMsg);

		String passErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
		Assert.assertEquals("This is a required field.", passErrorMsg);

	}

	@Test(enabled = false)
	public void TC_03_Login_With_Email_Invalid() {
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123434234");
		driver.findElement(By.xpath("//button[@id='send2']")).click();

	}

	@Test(enabled = false)
	public void TC_04_Login_With_Password_Incorrect() {
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();

		String passErrorMsg = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", passErrorMsg);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
